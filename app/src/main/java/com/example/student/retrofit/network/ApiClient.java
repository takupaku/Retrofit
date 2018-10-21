package com.example.student.retrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://localhost/student_database/";
                                                    //localhost=192.168.70.1//use IPv4 address from CMD command---->ipconfig
    //or use .......000webHost
    //0r............AwardSpace
    private static Retrofit retrofit = null;

    public static  Retrofit getApiClient(){
        if(retrofit == null ){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}


/*

C:\xampp\htdocs\student_database\api
<?php

FOLDER  NAME connect.php
.
.
.
.



$host_name = "localhost";
$user_name = "root";
$password = "";
$db_name = "student_database";

$conn = new mysqli($host_name,$user_name,$password,$db_name);
if($conn)
{

	//echo"connect success";
}
else{
	die("can't connect".$conn->connect_error);

}
?>
 */


/*

FOLDER  NAME get_data.php
.
.
.
.
<?php

require("connect.php");

$sql = "select * from student_table";
$data = $conn -> query($sql);

if($data){
	if($data ->num_rows> 0){
		$row = array();
		while($r= $data ->fetch_assoc())
		{
			$row[] = $r;
		}
		echo json_encode($row);
	}
	$conn->close();
	}
?>
 */

//--------------insert data in PHP code----------
/*

C:\xampp\htdocs\student_database\api
.
.
.
.
.
<?
require("connect.php");

$json = file_get_contents('php://input');//receiving in json format
$data = json_decode($json, true);//converting into array, and keeping it in data variable
$std_id = $data['student_id'];//keeping arrays in datas
$name = $data['name'];
$dept = $data['dept'];

$sql = "INSET INTO student_table (name,dept,student_id)
                                VALUES ('$name' , '$dept' ,'$std_id')";


$insert = $conn -> query($sql);

if($insert){
	echo json_encode(array('response' => 'successful'));//encoding into json format, if successful then this will show the msg
}

else{
	echo json_encode(array('response' => 'Failed'));

}
$conn ->close();

 */
