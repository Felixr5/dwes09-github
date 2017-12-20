<?php
class Cancion
{
    private $ID_CANCION;
    
    private $ID_ALBUM;
    
    private $NOMBRE;
    
    private $ID_AUTOR;
    
    private $DURACION;
   
    
    
    public function __toString()
    {
        // $imgs="/U3P03-PHP-Catalogo/img/";    . " <img src=" . $imgs . $this->imagen . " height=150 width=150>"
        
        $k=$this->ID_CANCION . " " . $this->ID_ALBUM . " " . $this->NOMBRE . " " . $this->ID_AUTOR . " " . $this->DURACION ;
        return $k;
    }
    
    public function getIDCANCION() {
        return $this->ID_CANCION;
        
    }
    
    public function getIDALBUM() {
        return $this->ID_ALBUM;
        
    }
    
    public function getNombre() {
        return $this->NOMBRE;
        
    }
    
    public function getIDAUTOR() {
        return $this->ID_AUTOR;
        
    }
    
    public function getDURACION() {
        return $this->DURACION;
        
    }
    
  /*  public function getImagen() {
        $imgs="/U3P03-PHP-Catalogo/img/";
        
        return "<img src=" . $imgs . $this->imagen . " height=150 width=150>";
      } */      
}
?>