<?php
if(!empty($_POST['telefono']) && !empty($_POST['password'])){
    $telefono = $_POST['telefono'];
    $password = $_POST['password'];
    $result = array();
    $con = mysqli_connect("localhost","root","VSOLIEB123Xu","nutriscan");
    if($con){
        $sql = "select * from usuarios where telefono = '".$telefono."'";
        $res = mysqli_query($con,$sql);
        if(mysqli_num_rows($res) !=0 ){
            $row = mysqli_fetch_assoc($res);
            if($telefono == $row['telefono'] && $password == $row['password']){
                $result = array("status" => "success","message" =>"Bienvenido","nombres"=>$row['nombres'],"apellidos"=>$row['apellidos'],"telefono"=>$row['telefono']);
                print json_encode($result);
            }else {$result = array("status" => "failed", "message" => "Verifique su contraseña y su telefono");
            print json_encode($result);}
        }else {$result = array("status" => "failed", "message" => "Verifique su contraseña y su telefono");
        print json_encode($result);}
    }else {$result = array("status" => "failed", "message" => "Error de conexion con base de datos");
    print json_encode($result);}
}else {$result = array("status" => "failed", "message" => "Debe ingresar todos los campos");
print json_encode($result);}
?>