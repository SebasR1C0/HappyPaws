package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.RolDTO;
import upc.edu.pe.happypaws.dtos.UsuarioDTO;
import upc.edu.pe.happypaws.entities.Rol;
import upc.edu.pe.happypaws.entities.Usuario;
import upc.edu.pe.happypaws.securities.JwtRequest;
import upc.edu.pe.happypaws.securities.JwtResponse;
import upc.edu.pe.happypaws.securities.JwtTokenUtil;
import upc.edu.pe.happypaws.serviceimplements.JwtUserDetailsService;
import upc.edu.pe.happypaws.serviceinterfaces.IRolService;
import upc.edu.pe.happypaws.serviceinterfaces.IUsuarioService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private IUsuarioService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRolService rS;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req) throws Exception {
        authenticate(req.getUsername(), req.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/user/id/{username}")
    public Long getUserIdByUsername(@PathVariable String username) {
        return uS.findByUsername(username);
    }

    @PostMapping("/registrar")
    public void registar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario urs = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(urs.getPassword());
        urs.setPassword(encodedPassword);
        uS.insert(urs);
    }

    @PostMapping("/rol")
    public void registrar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol nt = m.map(dto, Rol.class);
        rS.insert(nt);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }


    }
}