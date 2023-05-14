<?php
header("Access-Control-Allow-Origin: *");
$cn = new mysqli("localhost","root","VSOLIEB123Xu","nutriscan2");
$nombres = $_POST["nombres"] ??null;
$apellidos = $_POST["apellidos"] ??null;
$telefono = $_POST["telefono"] ??null;
$contraseña = $_POST["contraseña"] ??null;
$rs = $cn->query("INSERT INTO usuarios (nombres,apellidos,telefono,contraseña) values('$nombres','$apellidos','$telefono','$contraseña')");
echo $cn->insert_id;
$cn->close();
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