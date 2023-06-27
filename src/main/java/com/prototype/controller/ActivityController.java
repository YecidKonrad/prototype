package com.prototype.controller;

import static com.prototype.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.dto.ActivityDto;
import com.prototype.dto.ActivityRequestDto;
import com.prototype.exception.ExceptionHandling;
import com.prototype.service.ActivityService;
import com.prototype.service.impl.ReporteService;
import com.prototype.utility.JWTTokenProvider;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = { "JWT_TOKEN_HEADER", "Content-Disposition"},
allowedHeaders = { "Authorization", "Content-Type", "Content-Disposition" })
@RequestMapping(path = { "/activity" })
public class ActivityController extends ExceptionHandling {
	
	private ActivityService activityService;
	private ReporteService reporteService;

	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	public ActivityController(ActivityService activityService, JWTTokenProvider jwtTokenProvider, ReporteService reporteService) {
		this.activityService = activityService;
		this.jwtTokenProvider = jwtTokenProvider;
		this.reporteService = reporteService;
	}
	
	@GetMapping("/json")
	public ResponseEntity<ActivityRequestDto> generate(){
		return new ResponseEntity<>(new ActivityRequestDto(), OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ActivityDto> create(@RequestHeader(JWT_TOKEN_HEADER) String tokenHeader, @RequestBody ActivityRequestDto activityRequestDto) {
		ActivityDto activityResponseDto = activityService.create(activityRequestDto, jwtTokenProvider.getSubject(tokenHeader));
		return new ResponseEntity<>(activityResponseDto, OK);
	}
	@PostMapping("/update")
	public ResponseEntity<ActivityDto> update(@RequestHeader(JWT_TOKEN_HEADER) String tokenHeader, @RequestBody ActivityRequestDto activityRequestDto) {
		ActivityDto activityResponseDto = activityService.update(activityRequestDto, jwtTokenProvider.getSubject(tokenHeader));
		return new ResponseEntity<>(activityResponseDto, OK);
	}
	
	@GetMapping("/activities")
	public ResponseEntity<?> getActivities(){
		return new ResponseEntity<>(activityService.getAllActivitiesDetails(), OK);
	}
	
	@GetMapping("/states")
	public ResponseEntity<?> getPhasesStates() {
		return new ResponseEntity<>(activityService.getStateActivities(), OK);
	}
	 @GetMapping("/create-back-report")
	    public String getReporte(){
			Date today = new Date();
			String pattern = "MM-dd-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        if(reporteService.generateExcel(System.getProperty("user.dir") + "\\reports"+ "\\report-Activities-"+
			simpleDateFormat.format(today)+"-"+today.getHours()+"-"+today.getMinutes()+"-"+today.getTime()+".xlsx"))
	            return  "Reporte generado correctamente";
	        else
	            return "Ha ocurrido un error en la generacion del excel";
	    }
	 
	 @GetMapping(value = "/generateExcel")
	 public ResponseEntity<Object> generateExcel() {
	     try {
	         // Generar el nombre de archivo único
	         Date today = new Date();
	         String pattern = "MM-dd-yyyy";
	         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	         String fileName = "report-activities-" + simpleDateFormat.format(today) + "-" + today.getHours() + "-" + today.getMinutes() + "-" + today.getTime() + ".xlsx";

	         // Obtener la ruta completa del archivo
	         String filePath = System.getProperty("user.dir") + "\\reports\\" + fileName;

	         // Invocar el servicio para generar el archivo Excel
	         boolean success = reporteService.generateExcel(filePath);

	         if (success) {
	             // Obtener el archivo generado
	             File file = new File(filePath);

	             // Verificar si el archivo existe y se puede leer
	             if (file.exists() && file.canRead()) {
	                 byte[] content = Files.readAllBytes(file.toPath());

	                 // Crear un objeto JSON para enviar al frontend
	                 Map<String, Object> response = new HashMap<>();
	                 response.put("fileName", fileName);
	                 response.put("fileContent", Base64.getEncoder().encodeToString(content));

	                 // Devolver el objeto JSON como respuesta
	                 return new ResponseEntity<>(response, HttpStatus.OK);
	             } else {
	                 // Manejar el caso de archivo no encontrado o no legible
	                 // Devolver una respuesta de error apropiada
	                 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	             }
	         } else {
	             // Manejar el caso de error en la generación del archivo
	             // Devolver una respuesta de error apropiada
	             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	         }
	     } catch (IOException e) {
	         // Manejar el caso de error en la lectura del archivo
	         // Devolver una respuesta de error apropiada
	         System.out.println(e.getMessage());
	         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }





}
