<?php
if(!empty($_POST['nombres']) && !empty($_POST['apellidos']) && !empty($_POST['telefono']) && !empty($_POST['password'])){
    $con = mysqli_connect("localhost","root","VSOLIEB123Xu","nutriscan");
    $nombres = $_POST['nombres'];
    $apellidos = $_POST['apellidos'];
    $telefono = $_POST['telefono'];
    $password = $_POST['password'];
    if($con){
        $sql = "insert into usuarios (nombres,apellidos,telefono,password) values ('".$nombres."','".$apellidos."','".$telefono."','".$password."')";
        if(mysqli_query($con, $sql)){
            echo "success";
        }else echo "Registration failed";
    }else echo "Database connection failed";
}else echo "All fields are required";
/*header("Access-Control-Allow-Origin: *");
$cn = new mysqli("localhost","root","VSOLIEB123Xu","nutriscan2");
$nombres = $_POST["nombres"] ??null;
$apellidos = $_POST["apellidos"] ??null;
$telefono = $_POST["telefono"] ??null;
$password = $_POST["password"] ??null;
$rs = $cn->query("INSERT INTO usuarios (nombres,apellidos,telefono,password) values('$nombres','$apellidos','$telefono','$password')");
echo $cn->insert_id;
$cn->close();*/
/*include 'conexion.php';
$nombres=$_POST['nombres'] ?? null;
$apellidos=$_POST['apellidos'] ?? null;
$telefono=$_POST['telefono'] ?? null;
$contraseña=$_POST['contraseña'] ?? null;

$rs ="INSERT INTO usuarios (nombres, apellidos, telefono, contraseña) values ('$nombres','$apellidos','$telefono','$contraseña')";
//$consulta="insert into usuarios values ('".$nombres."','".$apellidos."','".$telefono."','".$contraseña."')";
//mysqli_query($conexion,$consulta);
mysqli_close($conexion);
    header("Access-Control-Allow-Origin: *");
    $cn = mysqli_connect("localhost","root","VSOLIEB123Xu","nutriscan");
    if (!$cn) {
        die("Connection failed: " . mysqli_connect_error());
    }

    echo "Connected successfully";

    $nombre = $_POST["nombres"] ?? null ;
    $apellido = $_POST["apellidos"] ?? null;
    $telefono = $_POST["telefono"] ?? null ;
    $contraseña = $_POST["contraseña"] ?? null;
    $rs ="INSERT INTO usuarios (nombres, apellidos, telefono, contraseña) values ('".$nombre."','".$apellido."','".$telefono."','".$contraseña."')";
    //echo $cn->insert_id;
    $cn->close(); */
?>