package riccardogulin.u5d7.controllers;

import org.springframework.web.bind.annotation.*;
import riccardogulin.u5d7.entities.User;

@RestController
// Specializzazione di @Component, ci serve per definire una "collezione" di endpoints
// Ogni endpoint sarà un metodo di questa classe)
@RequestMapping("/examples")
// Serve per definire un prefisso comune nell'URL di tutti gli endpoints di questo controller
public class ExampleController {

	@GetMapping("/getexample") // Qua definisco il metodo da utilizzare e la parte finale dell'URL
	public String getExample(){
		// Per contattare questo endpoint dovrò mandare una richiesta GET a http://localhost:numerodiporta/examples/getexample
		return "Ciao io rispondo alle richieste GET";
	}

	@PostMapping("/postexample")
	public String postMapping(){
		// Per contattare questo endpoint dovrò mandare una richiesta POST a http://localhost:numerodiporta/examples/postexample
		return "Ciao io rispondo alle richieste POST";
	}

	@PutMapping("/putexample")
	public String putExample(){
		// Per contattare questo endpoint dovrò mandare una richiesta PUT a http://localhost:numerodiporta/examples/putexample
		return "Ciao io rispondo alle richieste PUT";
	}

	@DeleteMapping("/deleteexample")
	public String deleteExample(){
		// Per contattare questo endpoint dovrò mandare una richiesta DELETE a http://localhost:numerodiporta/examples/deleteexample
		return "Ciao io rispondo alle richieste DELETE";
	}

	@GetMapping("/")
	public String get(){
		// Per contattare questo endpoint dovrò mandare una richiesta GET a http://localhost:numerodiporta/examples/
		return "GET";
	}

	@PostMapping("/")
	public String post(){
		// Per contattare questo endpoint dovrò mandare una richiesta POST a http://localhost:numerodiporta/examples/
		return "POST";
	}

	@PatchMapping("/")
	public String patch(){
		// Per contattare questo endpoint dovrò mandare una richiesta PATCH a http://localhost:numerodiporta/examples/
		return "PATCH";
	}

	@GetMapping("/pathParamExample/{parametro}")
	public String pathParamExample(@PathVariable String parametro){ // parametro deve corrispondere come nome a {parametro} dichiarato nell'URL
		// Per contattare questo endpoint dovrò mandare una richiesta GET a http://localhost:numerodiporta/examples/pathParamExample/oxzncoizjxcojxzocjxzoicjixozicj
		return "Il parametro che hai inserito è: " + parametro;
	}

	@GetMapping("/queryParamsExample")
	public String queryParamsExample(@RequestParam(required = false) String name, @RequestParam(required = false) String surname){
		// required = false mi rende il parametro NON obbligatorio (quindi il valore del parametro sarà null se non viene passato)
		// Per contattare questo endpoint dovrò mandare una richiesta GET a http://localhost:numerodiporta/examples/queryParamsExample?name=Aldo&surname=Baglio
		return "I parametri query che hai inserito sono: " + name + " " + surname;
	}

	@PostMapping("/payloadExample")
	public User payloadExample(@RequestBody User body){
        System.out.println("Ecco il payload inviato:");
        System.out.println(body);
		return body;
	}

}
