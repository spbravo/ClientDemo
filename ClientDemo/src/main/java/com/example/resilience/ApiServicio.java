package com.example.resilience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rx.Observable;
@EnableAutoConfiguration
@RestController
public class ApiServicio {

	@Autowired
	private StatusClient cliente;
	
	@Autowired
	private ConsultaEstado consulta;
	String respuesta = "";
	@Autowired
	private SampleBean counter;
	
	
	
	

	@RequestMapping(method = RequestMethod.PUT, path = "/invoca")
	public String Status(@RequestParam(value = "status", defaultValue = "nulo") String estado) {

		System.out.println("El nuevo estado va a ser " + estado);
		
	counter.handleMessage(estado);
	
		        
		// Observable<String> o = Observable.from(Arrays.asList(
		// Consulta.consulta("Santi"), cliente.update(estado)));
		Observable<String> o1 = Observable.defer(() -> Observable.just(consulta.consulta("Santi")));
		// System.out.println(Calendar.getInstance().getTimeInMillis()+"Justo
		// despues del primer observable ");
		Observable<String> o2 = Observable.defer(() -> Observable.just(cliente.update(estado)));
		// System.out.println(Calendar.getInstance().getTimeInMillis()+"Justo
		// despues del segundo observable ");
		Observable<String> Odef = Observable.merge(o2, o1);
		// System.out.println(Calendar.getInstance().getTimeInMillis()+"Aquí
		// despues del Merge");

		/*
		 * Odef.subscribe(new Action1<String>(){ public void call(String arg0) {
		 * //System.out.println(Calendar.getInstance().getTimeInMillis()
		 * +"Dentro del call "+arg0); respuesta+=arg0; } });
		 */
		// System.out.println("justo antes del suscribe");
		Odef.subscribe(System.out::println);
		// System.out.println("despues del suscribe");
		return "";
		/*
		 * @RequestMapping(method = RequestMethod.GET, path= "/aemet") public
		 * String AemetConsulta(@RequestParam(value="api_key", defaultValue=
		 * "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcGJyYXZvQGdtYWlsLmNvbSIsImp0aSI6IjgyNGM1Y2UzLWFmNzYtNDk0NS1hZDBmLTdhMDk1ZTIyMzJkZCIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNTA5NTU2OTY5LCJ1c2VySWQiOiI4MjRjNWNlMy1hZjc2LTQ5NDUtYWQwZi03YTA5NWUyMjMyZGQiLCJyb2xlIjoiIn0.XAEUT7p_9sXrkavMunL9CtQySwUWOicCIbGfsYxdVZk")
		 * String apiKey){ respuesta=clienteAemet.consulta(apiKey);
		 * System.out.println("El resultado final es "+respuesta); return
		 * respuesta; }
		 */

	}

	// cliente.update(estado);

	@RequestMapping(method = RequestMethod.GET, path = "/consulta")
	public String Consulta(@RequestParam(value = "nombre", defaultValue = "John") String name) {
		return consulta.consulta(name);

	}
}
