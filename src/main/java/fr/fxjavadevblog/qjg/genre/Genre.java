package fr.fxjavadevblog.qjg.genre;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Enumeration of all genre of Video Games for Atari ST.
 * 
 * @author robin
 *
 */
public enum Genre
{
   @JsonProperty(value = "arcade") 
   ARCADE, 
   
   @JsonProperty(value = "education") 
   EDUCATION, 
   
   @JsonProperty(value = "fighting")
   FIGHTING, 
   
   @JsonProperty(value = "pinball")
   PINBALL, 
   
   @JsonProperty(value = "plateform")
   PLATEFORM, 
   
   @JsonProperty(value = "reflexion")
   REFLEXION, 
   
   @JsonProperty(value = "rpg")
   RPG, 
   
   @JsonProperty(value = "shoot-them-up") 
   SHOOT_THEM_UP, 
   
   @JsonProperty(value = "simulation")
   SIMULATION,
   
   @JsonProperty(value = "sport")
   SPORT;
}
