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
