package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends Activity {
	
	TextView tv;
	Button b1,b2,b3,b4;
	public static int score=0;
	int pos=category.id;
	int count=0;
	String ques[];
	String[][] op;
	String ans[];
	
	
	String[] general={"Grand Central Terminal, Park Avenue, New York is the world's","For which of the following disciplines is Nobel Prize awarded?","Hitler party which came into power in 1933 is known as","FFC stands for","First China War was fought between","Friction can be reduced by changing from","During World War II, when did Germany attack France?","The ozone layer restricts","Filaria is caused by","Coral reefs in India can be found in"};
	String[][] gen={{"largest railway station","highest railway station","longest railway station","None of the above"},{"Physics and Chemistry","Physiology or Medicine","Peace and Economics","All of the above"},{"Labour Party","Nazi Party","Ku-Klux-Klan","Democratic Party"},{"Foreign Finance Corporation","Film Finance Corporation","Federation of Football Council","None of the above"},{"China and Britain","China and France","China and Egypt","China and Greek"},{"sliding to rolling","rolling to sliding","potential to kinetic energy","dynamic to static"},
			{"1940","1941","1942","1943"},{"Visible light","Infrared radiation","X-rays and gamma rays","Ultraviolet radiation"},{"Bacteria","Mosquito","Protozoa","Virus"},{"the coast of Orissa","Waltair","Rameshwaram","Trivandrum"}};
	String[] gk={"largest railway station","All of the above","Nazi Party","Film Finance Corporation","China and Britain","sliding to rolling","1940","Ultraviolet radiation","Mosquito","Rameshwaram"};
	
	String [] english={"Find the correctly spelt words","Find the correctly spelt words","In the following the questions choose the word which best expresses the meaning of the given word: CORPULENT","In the following the questions choose the word which best expresses the meaning of the given word:EMBEZZLE ","To keeps one's temper","To drive home","DIVA:OPERA","GRAIN:SALT","THRUST:SPEAR","PAIN:SEDATIVE"};
	String[][] eng={{"Efficient","Treatmeant","Beterment","Employd"},{"Foreign","Foreine","Fariegn","Forein"},{"Lean","Gaunt","Emaciated","Obese"},{"Misappropriate","Balance","Remunerate","Clear"},{"To become hungry","To be in good mood","To preserve ones energy","To be aloof from"},{"To find one's roots","To return to place of rest","Back to original position","To emphasise"},
			{"producer:theatre","director:drama","conductor:bus","thespian:play"},{"shard:pottery","shred:wood","shred:wood","chip:glass"},{"mangle:iron","scabbard:sword","bow:arrow","fence:epee"},{"comfort:stimulant","grief:consolation","trance:narcotic","ache:extraction"}};
	String[] e={"Efficient","Foreign","Obese","Misappropriate","To be in good mood","To emphasise","thespian:play","chip:glass","fence:epee","grief:consolation"};
	
	String [] physics={"The absorption of ink by blotting paper involves ","Nuclear sizes are expressed in a unit named ","Light year is a unit of ","Light from the Sun reaches us in nearly ","Pa(Pascal) is the unit for","Metals are good conductors of electricity because ","Pick out the scalar quantity ","Sound waves in air are ","Magnetism at the centre of a bar magnet is ","Of the following properties of a wave, the one that is independent of the other is its "};
	String[][] phy={{"viscosity of ink","capillary action","diffusion of ink through the blotting","siphon action"},{"Fermi","angstrom","newton","tesla"},{"time","distance","light","intensity of light"},{"2 minutes","4 minutes","8 minutes","16 minutes"},{"thrust","pressure","frequency","conductivity"},{"they contain free electrons","the atoms are lightly packed","they have high melting point","All of the above"},
			{"force","pressure","velocity","acceleration"},{"transverse","longitudinal","electromagnetic","polarised"},{"minimum","maximum","zero","minimum or maximum"},{"amplitude","velocity","wavelength","frequency "}};
	String[] p={"capillary action","Fermi","distance","8 minutes","pressure","they contain free electrons","pressure","longitudinal","zero","amplitude"};
	
	String [] chemistry={"The nucleus of an atom consists of","The number of moles of solute present in 1 kg of a solvent is called its","The most electronegative element among the following is","The metal used to recover copper from a solution of copper sulphate is","The number of d-electrons in Fe2+ (Z = 26) is not equal to that of","The metallurgical process in which a metal is obtained in a fused state is called","The most commonly used bleaching agent is","The nucleus of a hydrogen atom consists of","The heat required to raise the temperature of body by 1 K is called","The nuclear particles which are assumed to hold the nucleons together are"};
	String[][] chem={{"electrons and neutrons","electrons and protons","protons and neutrons","All of the above"},{"molality","molarity","normality","formality"},{"sodium","bromine","fluorine","oxygen"},{"Na","Ag","Hg","Fe"},{"p-electrons in Ne(Z = 10)","s-electrons in Mg(Z = 12)","d-electrons in Fe(Z = 26)","p-electrons in CI(Z = 17)"},{"smelting","roasting","calcinations","froth floatation"},
			{"alcohol","carbon dioxide","chlorine","sodium chloride"},{"1 proton only","1 proton + 2 neutron","1 neutron only","1 electron only"},{"specific heat","thermal capacity","water equivalent","None of the above"},{"electrons","positrons","neutrons","mesons"}};
	String[] c={"protons and neutrons","molality","fluorine","Fe","p-electrons in CI(Z = 17)","smelting","chlorine","1 proton only","thermal capacity","mesons"};
	
	String [] movies={"Who is popularly known as 'Father of Indian Cinema'?","Which actress made her debut along with Raj Kapoor with film 'Neel Kamal'?","Music Director R.D. Burman is also known as ……………………","Which Indian actor is known as 'Tragedy King'?","Which was the last movie directed by Yash Chopra?","Amitabh Bachchan suffered a near fatal intestinal injury during the shooting of which film?","Which of these is not related to Hema Malini?","Singer Kishore Kumar bagged first Filmfare Award for which song?","Beautiful actress Madhubala was married to ……………………","Name the film in which Amitabh Bachchan, Rajinikanth and Kamal Hasan worked together."};
	String[][] mov={{"Dadasaheb Phalke","V. Shantaram","Ardeshir Irani","Kidar Sharma"},{"Nargis","Vyjayanthimala","Madhubala","Meena Kumari"},{"Rocky","Pancham","Chichi","Chintu"},{"Sanjeev Kumar","Guru Dutt","Amitabh Bachchan","Dilip Kumar"},{"Rab Ne Bana Di Jodi","Jab Tak Hai Jaan","Veer Zara","Ek Tha Tiger"},{"Agneepath","Zanjeer","Coolie","Sholay"},
			{"Politics","Dance","Sports","Bollywood"},{"Roop Tera Mastana","Dil Aisa Kisi Ne Mera","Khaike Pan Banaras Wala","Zindagi Ek Safar"},{"Raj Kapoor","Dilip Kumar","Premnath","Kishore Kumar"},{"Hum","Andha Kanoon","Agneepath","Geraftaar"}};
	String[] m={"Dadasaheb Phalke","Madhubala","Pancham","Dilip Kumar","Jab Tak Hai Jaan","Coolie","Sports","Roop Tera Mastana","Kishore Kumar","Geraftaar"};
	
	String [] cricket={"Former Australian captain Mark Taylor has had several nicknames over his playing career. Which of the following was NOT one of them?","Which was the 1st non Test playing country to beat India in an international match?","Which county did Ravi Shastri play for?","Which two counties did Kapil Dev play?","Ricky Ponting is also known as what?","The nickname of Glenn McGrath is what?","Mark Waugh is commonly called what?","Which player has scored the most runs in a single Test innings?","Who was the 1st ODI captain for India?","Where did India play its 1st one day international match?"};
	String[][] cric={{"Tubby","Stodge","Helium Bat","Stumpy"},{"Canada","Sri Lanka","Zimbabwe","East Africa"},{"Glamorgan","Leicestershire","Gloucestershire","Lancashire"},{"Northamptonshire & Worcestershire","Northamptonshire & Warwickshire","Nottinghamshire & Worcestershire","Nottinghamshire & Warwickshire"},{"The Rickster","Ponts","Ponter","Punter"},{"Ooh Ahh","Penguin","Big Bird","Pigeon"},
			{"Afganistan","Junior","Tugga","Julio "},{"Graham Gooch","Matthew Hayden","Brian Lara","Agarkar"},{"Ajit Wadekar","Bishen Singh Bedi","Nawab Pataudi","Vinoo Mankad"},{"Lords","Headingley","Taunton","The Oval"}};
	String[] cc={"Helium Bat","Sri Lanka","Glamorgan","Northamptonshire & Worcestershire","Punter","Pigeon","Afganistan","Brian Lara","Ajit Wadekar","Headingley"};
	
	
	String [] technology={"In which decade was the American Institute of Electrical Engineers (AIEE) founded?","What is part of a database that holds only one type of information?","'OS' computer abbreviation usually means?","'.MOV' extension refers usually to what kind of file?","Which is a type of Electrically-Erasable Programmable Read-Only Memory?","The purpose of choke in tube light is?","Who developed Yahoo?","What does VVVF stand for?","What frequency range is the High Frequency band?","A given signal's second harmonic is twice the given signal's _________"};
	String[][] tech={{"1850s","1880s","1930s","1950s"},{"Report","Field","Record","File"},{"Order of Significance","Open Software","Operating System","Optical Sensor"},{"Image file","Animation/movie file","Audio file","MS Office document"},{"Flash","Flange","Fury","FRAM"},{"To decrease the current","To increase the current","To decrease the voltage momentarily","To increase the voltage momentarily"},
			{"Dennis Ritchie & Ken Thompson","David Filo & Jerry Yang","Vint Cerf & Robert Kahn","Steve Case & Jeff Bezos"},{"Variant Voltage Vile Frequency","Variable Velocity Variable Fun","Very Very Vicious Frequency","Variable Voltage Variable Frequency"},{"100 kHz","1 GHz","30 to 300 MHz","3 to 30 MHz"},{"Fourier","Foundation","Fundamental","Field"}};
	String[] t={"1880s","Field","Operating System","Animation/movie file","Flash","To increase the voltage momentarily","David Filo & Jerry Yang","Variable Voltage Variable Frequency","3 to 30 MHz","Fundamental"};
	
	String [] history={"The Battle of Plassey was fought in","The trident-shaped symbol of Buddhism does not represent","The use of Kharoshti in ancient Indian architecture is the result of India's contact with","Todar Mal was associated with","Two of the great Mughals wrote their own memories. There were","To which king belongs the Lion capitol at Sarnath?","The use of spinning wheel (Charkha) became common during the","The language of discourses of Gautama Buddha was","Tipu sultan was the ruler of","'The Vedas contain all the truth was interpreted by"};
	String[][] his={{"1757","1782","1748","1764"},{"Nirvana","Sangha","Buddha","Dhamma"},{"Central Asia","Iran","Greece","China"},{"music","literature","land revenue reforms","law"},{"Babar and Humayun","Humayun and Jahangir","Babar and Jahangir","Jahangir and Shahjahan"},{"Chandragupta","Ashoka","Kanishka","Harsha"},
			{"9th Century AD","10th Century AD","12th Century AD","14th Century AD"},{"Bhojpuri","Magadhi","Pali","Sanskrit"},{"Hyderabad","Madurai","Mysore","Vijayanagar"},{"Swami Vivekananda","Swami Dayananda","Raja Rammohan Roy","None of the above"}};
	String[] h={"1757","Nirvana","Greece","land revenue reforms","Babar and Jahangir","Ashoka","14th Century AD","Pali","Mysore","Swami Dayananda"};
	
	String [] geography={"The percentage of irrigated land in India is about","The pass located at the southern end of the Nilgiri Hills in south India is called","The Yarlung Zangbo river, in India, is known as","The Salal Project is on the river","The percentage of earth surface covered by India is","The Radcliffe line is a boundary between","The state having a largest area of forest cover in India is","The year ____ is called a Great Divide in the demographic history of India.","The only state in India that produces saffron is","The zonal soil type of peninsular India belongs to"};
	String[][] geo={{"45","65","35","25"},{"the Palghat gap","the Bhorghat pass","the Thalgat pass","the Bolan pass"},{"Ganga","Indus","Brahmaputra","Mahanadi"},{"Chenab","Jhelum","Ravi","Sutlej"},{"2.4","3.4","4.4","5.4"},{"India and Pakistan","India and China","India and Myanmar","India and Afghanistan"},
			{"Arunachal Pradesh","Haryana","Madhya Pradesh","Assam"},{"1901","1921","1941","1951"},{"Assam","Himachal Pradesh","Jammu and Kashmir","Meghalaya"},{"red soils","yellow soils","black soils","older alluvium"}};
	String[] g={"35","the Palghat gap","Brahmaputra","Chenab","2.4","India and Pakistan","Madhya Pradesh","1921","Jammu and Kashmir","red soils"};
	
	public void display(int count,String[][] option,String[] ques)
	{
		if(count>=10)
			  {
			
			   Intent in = new Intent(getApplicationContext(), result.class);
			   startActivity(in);
			  return;
			  }
		/*b1.setBackgroundColor(0x00000000);
		b2.setBackgroundColor(0x00000000);
		b3.setBackgroundColor(0x00000000);
		b4.setBackgroundColor(0x00000000);
		*/
		
	
		tv.setText(ques[count]);
		b1.setText(option[count][0]);
		b2.setText(option[count][1]);
		b3.setText(option[count][2]);
		b4.setText(option[count][3]);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 setContentView(R.layout.quiz);
		tv=(TextView) findViewById(R.id.textView1);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		b4=(Button) findViewById(R.id.button4);
		
		
		if(category.id==0){ques=general;op=gen;ans=gk;};
		if(category.id==1){ques=english;op=eng;ans=e;};
		if(category.id==2){ques=physics;op=phy;ans=p;};
		if(category.id==3){ques=chemistry;op=chem;ans=c;};
		if(category.id==4){ques=movies;op=mov;ans=m;};
		if(category.id==5){ques=cricket;op=cric;ans=cc;};
		if(category.id==6){ques=technology;op=tech;ans=t;};
		if(category.id==7){ques=history;op=his;ans=h;};
		if(category.id==8){ques=geography;op=geo;ans=g;};
		
		
	   
			display(count,op,ques);
			int oldscore=score;
		View.OnClickListener myhandler = new View.OnClickListener() {
			  public void onClick(View v) {
			      switch(v.getId()) {
			        case R.id.button1:
			          if(b1.getText().toString()==ans[count]){score++;Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();}
			          else{Toast.makeText(getApplicationContext(),"Wrong!",Toast.LENGTH_SHORT).show();}
			          count++;display(count,op,ques);
			          break;
			        case R.id.button2:
			        	if(b2.getText().toString()==ans[count]){score++;Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();}
			        	else{Toast.makeText(getApplicationContext(),"Wrong!",Toast.LENGTH_SHORT).show();}
			        	count++;display(count,op,ques);
			          break;
			        case R.id.button3:
			        	if(b3.getText().toString()==ans[count]){score++;Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();}
			        	else{Toast.makeText(getApplicationContext(),"Wrong!",Toast.LENGTH_SHORT).show();}
			        	count++;display(count,op,ques);
				          break;
			        case R.id.button4:
			        	if(b4.getText().toString()==ans[count]){score++;Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();}
			        	else{Toast.makeText(getApplicationContext(),"Wrong!",Toast.LENGTH_SHORT).show();}
			        	count++;display(count,op,ques);
				          break;
			      }
			  }
			};
			b1.setOnClickListener(myhandler);
		    b2.setOnClickListener(myhandler);
		    b3.setOnClickListener(myhandler);
		    b4.setOnClickListener(myhandler);
		    
		 
		super.onCreate(savedInstanceState);
	}
	

}
