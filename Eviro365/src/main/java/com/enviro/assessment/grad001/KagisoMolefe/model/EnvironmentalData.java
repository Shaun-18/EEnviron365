
package com.enviro.assessment.grad001.KagisoMolefe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EnvironmentalData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Data is mandatory")
    @Size(max = 255, message = "Data cannot be longer than 255 characters")
    private String data;

	public void setData(String content) {
		// TODO Auto-generated method stub
		
	}

    // Getters and Setters
}
