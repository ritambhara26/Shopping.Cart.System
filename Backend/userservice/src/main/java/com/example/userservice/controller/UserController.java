package com.example.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.UserModel;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.securityconfig.AuthenticationRequest;
import com.example.userservice.securityconfig.AuthenticationResponse;
import com.example.userservice.service.MyUserService;
import com.example.userservice.service.UserService;
import com.example.userservice.util.JwtUtils;

@RestController
@CrossOrigin(origins="*")
public class UserController{
	
@Autowired
JwtUtils jwtutil;

@Autowired
MyUserService userservice;

@Autowired
UserRepository userrepo;

@Autowired
AuthenticationManager authenticates;

@Autowired
UserService uservice;
@PostMapping("/subs")

public ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authreq)
{
String username=authreq.getUsername();
String password=authreq.getPassword();

UserModel usermodel =new UserModel();
usermodel.setUsername(authreq.getUsername());
usermodel.setPassword(authreq.getPassword());

try {
	userrepo.save(usermodel);
}
catch(Exception e)
{
return ResponseEntity.ok("Error during subscription");
}

return ResponseEntity.ok("Successfully subcribed "+username);
}



@PostMapping("/auth")

public ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
{



String username=authenticationRequest.getUsername();
String password=authenticationRequest.getPassword();

try
{
	authenticates.authenticate(new UsernamePasswordAuthenticationToken(username,password));
}
catch(Exception e)
{
return ResponseEntity.ok("Error during authentication");
}

UserDetails userdetails= uservice.loadUserByUsername(username);

String generatedToken=jwtutil.generateToken(userdetails);



return ResponseEntity.ok(generatedToken );
//return ResponseEntity.ok(new AuthenticationResponse("Successfully subcribed "+username));

}

@GetMapping("/test")
private String testingtoken() {
try {
return "Testing Successful...!";
}
catch(Exception e) {
return "Please login first..!";
}
}

@GetMapping("/dashboard")
private String dashboard() {
return "Welcome to dashboard...!";
}
@RequestMapping("/user")
public List<UserModel>getAllUsers()

{
return userservice.getAllUsers();
}



@RequestMapping(method=RequestMethod.POST, value="/user")
public void add(@RequestBody UserModel us)
{
userservice.add(us);
}


@RequestMapping(method=RequestMethod.PUT, value="/user/{Id}")
public void UpdateUser(@RequestBody UserModel us,@PathVariable String Id)
{
userservice.Update(Id,us);
}


@RequestMapping(method=RequestMethod.DELETE, value="/user/{Id}")
public void deleteUser(@RequestBody UserModel us)
{
userservice.delete(us);
}
}
