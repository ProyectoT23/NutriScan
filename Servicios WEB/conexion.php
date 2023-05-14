<?php
    $hostname='localhost';
    $database='nutriscan2';
    $username='root';
    $password='VSOLIEB123Xu';

    $conexion=new mysqli($hostname,$username,$password,$database);
    if($conexion->connect_errno){
        echo "Estamos experimentando problemas, intente mas tarde";
    }
    else{
        echo "Conexion exitosa";
    }
?>