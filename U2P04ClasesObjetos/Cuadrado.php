<?php
class Cuadrado {
    public $base;
    public $altura;
    
    function calcularArea() {
        return ($this->base * $this->altura);   
    }
    
    function calcularPerimetro() {
        return ($this->base * 2) + ($this->altura * 2);
    }
}
?>