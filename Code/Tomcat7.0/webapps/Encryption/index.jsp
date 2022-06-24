
<center>
<SCRIPT LANGUAGE="JavaScript">
<!--

// By PATRICK CLINGER (pat_clinger@hotmail.com)
// Web Site: http://www.proboards.com/
// Script featured on JavaScript Kit (http://javascriptkit.com)
// Over 400+ free scripts: javascriptkit.com<br />

var letters = 'ghijklabvwxyzABCDEFef)_+|<>?:mnQRSTU~!@#$%^VWXYZ`1234567opGHIJKLu./;'+"'"+'[]MNOP890-='+'\\'+'&*("{},cdqrst '+"\n";
var split = letters.split("");
var num = '';
var c = '';
var encrypted = '';
function encrypt(it)
{	 
	var b = '0';
	var chars = it.split("");
	while(b<it.length)      
	{
		c = '0';
		while(c<letters.length)
		{
			if(split[c] == chars[b])
			{
				if(c == "0") { c = ""; }
				if(eval(c+10) >= letters.length)
				{num = eval(10-(letters.length-c));encrypted += split[num];}
				else{num = eval(c+10);encrypted += split[num];}
			}c++;
		}b++;
	}document.forms[0].data.value = encrypted;encrypted = '';
}
function decrypt(it)
{
	 var text_box = document.getElementById('target');
	 text_box.setAttribute('readonly', 'readonly'); 
	
	var b = '0';var chars = it.split("");while(b<it.length){c = '0';while(c<letters.length){if(split[c] == chars[b]){if(c == "0") { c = ""; }if(eval(c-10) < 0){num = eval(letters.length-(10-c));encrypted += split[num];}else{num = eval(c-10);encrypted += split[num];}}c++;}b++;}document.forms[0].data.value = encrypted;encrypted = '';

}
// -->
</SCRIPT>
<div style="height:20px;width:530px;position:absolute;top:125px;left:220px;border:2px solid #9D9D9D;padding:15;">
<center>Encryption And Decryption</center>
</div> 
<div style="height:170px;width:500px;position:absolute;top:170px;left:220px;border:2px solid #9D9D9D;padding:30;background-color:#9D9D9D">
<FORM>
Enter Yout Text
<TEXTAREA ROWS="9" COLS="60" NAME="data" id="target" wrap="virtual" ></TEXTAREA><BR>
<INPUT TYPE="BUTTON" VALUE="Encrypt" onClick="encrypt(document.forms[0].data.value)">
<INPUT TYPE="BUTTON" VALUE="Decrypt" onClick="decrypt(document.forms[0].data.value)">
</FORM>
</div>