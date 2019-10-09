<?php 
//error_reporting(0);
header("content-Type: text/html; charset=utf-8");//输出编码

//#############################################################
//#作者邮箱: admin@ewuyi.net                                  #
//#作者主页: http://12391.net/                                #
//#系统定制：http://aiyaha.taobao.com			      #
//#############################################################

function PostXml($url, $post) { 
 $curl = curl_init();
 curl_setopt($curl, CURLOPT_URL, $url);
 curl_setopt($curl, CURLOPT_HEADER, 0);
 curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
 curl_setopt($curl, CURLOPT_HTTPHEADER, array("Content-type: text/xml"));
 curl_setopt($curl, CURLOPT_POST, 1);
 curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
 $PostXml = curl_exec($curl);//执行cURL 
 curl_close($curl);
 return $PostXml; 
} 


$times=time();
$mpurl = trim($_POST['mpurl']);
$mptoken = trim($_POST['mptoken']);
$mpxml = trim($_POST['mpxml']);

if(!$mpurl){
$mpurl="http://asp.96448.cn/_weixin/chengji.asp";
}

$bb=stristr($mpurl,"?");

$mpxmls=strlen($mpxml);

if($mpxmls>7){

//echo $mpurl."-->".$mpxml;
$DoPostXml=PostXml($mpurl, $mpxml);

}else{


$nonce = "";
for ($i = 0; $i < 8; $i++) {
	$nonce .= rand(0, 9);
}

 $echoStr = $nonce;
 $timestamp = $times;

 $tmpArr = array($mptoken, $timestamp, $nonce);
 sort($tmpArr, SORT_STRING);
 $tmpStr = implode($tmpArr);
  $signature = sha1($tmpStr);

if($bb){
$mpurl=$mpurl."timestamp=$times&nonce=$nonce&signature=$signature&echostr=$mptoken";
}else{
$mpurl=$mpurl."?timestamp=$times&nonce=$nonce&signature=$signature&echostr=$mptoken";
}

//echo $mpurl."-->Token!";
$WiPostXml=PostXml($mpurl, "");
if($WiPostXml==$mptoken){
$DoPostXml = '{"status": "1"}';
}else{
$DoPostXml = '{"status": "0"}';
}

}


exit($DoPostXml);
?>