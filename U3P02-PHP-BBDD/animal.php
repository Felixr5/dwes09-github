<?php

class animal
{

    private $chip;
   
    private $nombre;
   
    private $especie;
   
    private $imagen;
   
    
    public function __toString()
    {
        $imgs="/U3P02-PHP-BBDD/img/";
        
        $k=$this->chip . " " . $this->nombre . " " . $this->especie . " <img src=" . $imgs . $this->imagen . " height=150 width=150>";
        return $k;
    }
    
    public function getChip() {
        return $this->chip;
        
    }
    
    
    public function getNombre() {
        return $this->nombre;
        
    }
    
    public function getEspecie() {
        return $this->especie;
        
    }
    
    public function getImagen() {
        $imgs="/U3P02-PHP-BBDD/img/";
        
        return "<img src=" . $imgs . $this->imagen . " height=150 width=150>";
        
    }
}
?>