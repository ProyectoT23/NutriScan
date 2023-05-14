<?php
if(!empty($_POST['telefono'])){
    $telefono = $_POST['telefono'];
    $result = array();
    $con = mysqli_connect("localhost","root","VSOLIEB123Xu","nutriscan");
    if($con){
        $sql = "select * from usuarios where telefono = '".$telefono."'";
        $res = mysqli_query($con,$sql);
        if(mysqli_num_rows($res) !=0 ){
            $row = mysqli_fetch_assoc($res);
            $result = array("status" => "success","message" => "Los datos son:","nombres"=>$row['nombres'],"apellidos"=>$row['apellidos'],"telefono"=>$row['telefono']);
            echo "El resultado es'" .$result."'";
        }else echo "Acceso no autorizado";
    }else echo "Database connection failed";
}else echo "All fields are required";
?>