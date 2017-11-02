<?php
    class Triangulo {
        public $base;
        public $altura;
        
        function calcularArea() {
            return ($this->base * $this->altura) / 2;
        }
    }
?>