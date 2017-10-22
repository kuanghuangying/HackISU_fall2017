import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;

class Analysis {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR= "\n";
	private static final String FILE_HEADER = "company0,job_title0,descrip0,company1,job_title1,descrip1,company2,job_title2,descrip2,company3,job_title3,descrip3,company4,job_title4,descrip4,school,degree,school_score,skill_score";


	/* findSchoolScore()
	 * findGPA()
	 * findNumberWorkExperiences()
	 * findYearsOfExperience()
	 * findSkillSimilarity()
	 */
	static String[] all_txt_files = {"Smit_Shah.txt", "Mavin_Martin.txt", "Sina_Ariyan.txt", "Chase_Ziwen_Cao.txt", "XiangbingJiProfile.txt", "Anurag_Bitton.txt", "p1.txt", "HaoGaiProfile.txt", "Zhou_Yu.txt", "Yufan_Lu.txt", "Zidong_Liu.txt", "Shiv_Patel.txt", "Aaron_Iglesias.txt", "Qing_Zhang.txt", "Jinal_Shah.txt", "Michael_Bediako.txt", "Tao_Ning.txt", "Alexey_Klishin.txt", "Lei_Wang.txt", "Alen_Kubati.txt", "Zach_Dischner.txt", "Xiwen_Zhang.txt", "Rohit_Sinha.txt", "Jerry_Luo.txt", "Swaroop_Manjunath.txt", "Bo_Yi.txt", "Dhrupad_Bhardwaj.txt", "Anshuman_Bansal.txt", "William_S._Fuller.txt", "Derrick_Chie.txt", "Mengfan_Chen.txt", "Zohaib_Iqbal.txt", "Alex_Vaky.txt", "Grace_Liu.txt", "Sharad_Banka.txt", "Aaron_Pankratz.txt", "Solaris_Nite.txt", "Feihong_Yang.txt", "Son_Pham.txt", "Sikai_Zhu.txt", "Shivani_Patil.txt", "Kevin_Nguyen.txt", "Tushar_Bhandari.txt", "Tyler_Bui-Palsulich.txt", "Mojtaba_Seyedhosseini.txt", "Shu_Wang.txt", "Michael_Taufen.txt", "Renchi_Yan.txt", "Akshay_Joshi.txt", "Raghav_Baldania.txt", "Michael_Bucher.txt", "Truman_Cranor.txt", "Luke_Lancaster.txt", "PJ_McNerney.txt", "Rundong_Lyu.txt", "Raisa_Cuevas.txt", "Ahmad_Zaraei.txt", "Shuguang_Han.txt", "Niharika_Ray.txt", "Animesh_Seth.txt", "Anuja_verma.txt", "Lingyun_Ruan.txt", "Hongyu_Song.txt", "Jialin_Yu.txt", "Ankit_Agarwal.txt", "Ribel_Fares.txt", "Morgan_Aw.txt", "Zhiwen_Fang.txt", "Hengchin_Yeh.txt", "Haitham_Gabr.txt", "Noah_Crocker.txt", "Anirudh_Subramanian.txt", "Liang_Tang.txt", "Harsha_Hassan_Somashekara.txt", "Li_Li.txt", "Ashish_Rathi.txt", "Ricardo_Alberto_Gaviria.txt", "Johann_Kerbrat.txt", "Cong_Qiao.txt", "Robert_Sperry.txt", "Madeleine_Esson.txt", "Vaishakh_Baragur_Narasimhareddy.txt", "Nathan_Stender.txt","Estevao_Hess__CSM__CSP__MSc.txt","sandeep_ks.txt","Aaron_Huang.txt","Anthony_Randolph.txt","Vasavi_Vempati.txt","Madhav_Patel.txt","Vadim_Iljin.txt","Xiao_Cai.txt","Ankita_Girish_Wagh.txt","Dipan_Padsumbia.txt","Xin_Sun.txt","Ted_Meyer.txt","Deepak_Aakula.txt","Robert_Mahieu.txt","Shikai_Tang.txt","Akshit_Axe_Soota.txt","Raghavendra_Srinivasan.txt","Fan_Jin.txt","null.txt","Karen_Delgado.txt","Nathan_Woo.txt","Priyankar_Nandi.txt","Prince_Vohra.txt","Manjeet_Singh_Bhatia.txt","Cong_Kong.txt","Leo_Liu.txt","Chengxiong_Ruan.txt","Zeyao_Yang.txt","Eugene_Udezi__MBA.txt","Surabhi_Agrawal.txt","Krishma_Dutta.txt","Wodan_Zhou.txt","Xianglong_Kong.txt","Inho_Yong.txt","Jayanth_Silesh.txt","Manoj_Rawat.txt","Jennifer_Treichler.txt","Brendan_Shanny.txt","Rajesh_M.txt","Justin_Ehlert.txt","Kei_Kudose.txt","Ravi_Karanam.txt","Akankshu_Dhawan.txt","Han_Lin.txt","Yinan_Fang.txt","SABA_NOUSHEEN.txt","Sherzod_Muratov.txt","Greg_Silk.txt","Kalle_Koivisto.txt","James_Sullivan.txt","Tiffany_Tung.txt","Jesse_Spears.txt","Kevin_Tian.txt","Vikas_Paliwal.txt","Abhinit_Sinha.txt","Xiaodong_Liu.txt","Jordan_Bonser.txt","Shankhoneer_Chakrovarty.txt","Mohammed_Abdelkhaliq.txt","Dmytro_Kashyn__PhD.txt","Krishna_Chaitanya_Pabbuleti.txt","Ethan_Johnson.txt","Vaibhav_Gandhi.txt","Joan_Canéus.txt","Jon_Sadka.txt","Yuxuan_Liu.txt","Vamsi_Goparaju.txt","Jinyi_Guo.txt","Vikrant_Gimonkar.txt","Bardia_Beigi.txt","Ahmed_Abdi.txt","Yunhong_Xu.txt","Melissa_Blotner.txt","Shawn_Seymour.txt","Dinesh_Ramasamy.txt","George_Sebastian.txt","Nischal_Guruprasad.txt","Guilherme_Campos_Camargo.txt","Samarth_Savanur.txt","Sujit_Das.txt","Hanbo_Wang.txt","Jingcong_Wang.txt","Pujitha_Sri_Lakshmi_Paladugu.txt","Ilaria_Varriale.txt","Ankit_Patel.txt","Sandeep_Anil_Rodrigues.txt","Chetan_Reddy.txt","Dongpu_Jin.txt","Vladimir_Zaytsev.txt","Dipanshu_Gupta.txt","Eric_Sanchez_Lopez.txt","Wil_Yegelwel.txt","Alin_Gabriel_Arhip.txt","Sonalisa_Pal.txt","Sachin_Nambiar_Nalavattanon.txt","Andrea_Silkey.txt","Priya_Dhumal.txt","Gajendranath_Gaurav_Roy_Puli.txt","Zachary_Sweigart.txt","Rahis_Shaikh.txt","Shuowei_Li.txt","Kavitha_Krovi.txt","Joshua_Wong.txt","Motonari_Ito.txt","Abhyuday_Uday_Chakravarthi.txt","Shreya_Gupta.txt","Ariana_Weinstock.txt","Parth_Ahluwalia.txt","Fabrice_Gesbert.txt","Deepesh_C_P.txt","Kumar_Chandan.txt","Aditya_K.txt","Ameya_Pandilwar.txt","Aaditya_Uppal.txt","Qingkun_Li.txt","A_Subrahmanyam.txt","Aarohan_Badami.txt","Navid_Rojiani.txt","Chuntao_Lu.txt","CJ_Sorensen.txt","Tatparya_Shankar.txt","anthony_veigel.txt","Alexander_Swafford.txt","Thom_Dixon.txt","Tjitse_Miller.txt","Akshay_Dabholkar.txt","Jeremy_Nolan.txt","Ryan_Scott.txt","Brandon_Robinson.txt","NyoMe_Han.txt","Gong_Ke_Gouldstone.txt","Santosh_Shankar.txt","Oscar_Suarez.txt","David_Yin.txt","Aaron_Anderson.txt","Olivia_Liao.txt","Gaurav_Sharma.txt","Yashwanth_Gazula.txt","Cheng_Han.txt","Dominic_Bett.txt","Tianyu_Yang.txt","Ketan_Kapasi.txt","Divya_Matta.txt","Kimberly_Shen.txt","Josh_Ransom.txt","Luming_Liang.txt","Travis_Galloway.txt","Harsh_Jain.txt","Ankit_Agarwal.txt","Steve_Sun.txt","Rahul_Mehrotra.txt","Jesús_Eduardo_Córdova_Herrero.txt","Lakshman_Pasala.txt","Zhong_Wang.txt","Madhuri_Devidi.txt","Joseph_Garcia.txt","Eric_Turner.txt","Jingxuan_Li.txt","Aliaksei_Litouka.txt","Ezra_Chu.txt","Derek_Tsay.txt","Xin_Huang.txt","Sarthak_Shah.txt","Casey_Gowrie.txt","Marcus_Williams.txt","Ankita_Verma.txt","Bhavya_Arora.txt","Meenal_Vyas.txt","Esha_Joshi.txt","Ada-Mihaela_Solcan.txt","Jake_Jermanok.txt","Rashmi_Shukla.txt","Zara_Ahmed.txt","Nadya_Ortiz.txt","Poorvaja_Rajagopal.txt","Abdulhalim_Bambang_Sunaryo.txt","Mark_Lester_Halili.txt","Ashish_Singh.txt","Jemale_Lockett.txt","Travis_Cook.txt","Richa_Khandelwal.txt","Dylan_Dunnan.txt","LieHuo_Chen.txt","Anthony_Queen.txt","Alice_Tan.txt","Richard_Cho.txt","Supriya_Bansal.txt","Piyush_Anil_Nahar.txt","Travis_Nguyen.txt","Sriramprabhu_Sankaraguru.txt","Somesh_Maurya.txt","Samuel_Russell.txt","Joanne_Bruno.txt","Sneha_Muralidharan.txt","Tomas_Piaggio.txt","Gaston_Agustin_Lucero_Berrini.txt","Leo_Yi.txt","Stephen_Chen.txt","Sanjay_Kumar.txt","Phil_Albu.txt","Zhao_Chen.txt","Dmitry_Bessarab.txt","Ritika_Mehta.txt","Shivaraman_Shankar.txt","Jagdeep_Singh.txt","Srikar_Varanasi.txt","Keagan_Goetsch.txt","Christian_Moreno.txt","lakshmi_Chowdary.txt","Taha_Saifuddin.txt","Ariel_Stolerman.txt","Reena_Thakre.txt","Frank_DiRosa_IV.txt","Stephen_Kearns.txt","John_Matze.txt","Lei_XU.txt","Pavankumar_Kolla.txt","M_hammed_OULAIDI.txt"};

	static String[] top_colleges = { "harvard university", "stanford university",
"princeton university new jersey", "yale university", "williams college massachusetts", "pomona california college", "brown university", "swarthmore college pennsylvania", "amherst college", "massachusetts college of technology",
"university of pennsylvania", "university of notre dame indiana", "darmouth college new hampshire", "columbia university in the city of new york", "northwestern illinois university", "duke university north carolina", "tufts university massachusetts", "claremont college california", "georgetown university", "cornell university new york", "wesleyan university connecticut", "university of chicago",
"davidson college north carolina", "wellesley college massachusetts", "rice texas", "washington lee university virginia", "carleton college minnesota", "technology institute california", "middlebury college vermont", "university of california berkeley", "university of virginia", "boston college massachusetts", "university of california los angeles", "william mary college virginia", "colgate university new york", "university michigan ann arbor", "barnard college new york",
"bucknell university", "colby college maine", "vanderbilt university tennessee", "johns hopkins university maryland", "kenyon college ohio", "university of north carolina chapel hill", "oberlin college ohio", "whitman college washington", "hamilton college new york",
"reed college oregon", "lafayette college pennsylvania", "holy cross college massachusetts", "washington university in st louis", "carnegie mellon university pennsylvania", "harvey mudd college california", "franklin and marshall college", "wake forest university north carolina", "university of rochester", "colorado college", "university of southern california", "grinnell college iowa", "macalester college minnesota", "university of illinois at urbana champaign", "university wisconsin madison", "bates college maine", "villanova university pennsylvania", "lehigh university pennsylvania", "brandeis university massachusetts", "university of washington", "new york university", "emory university georgia", "trinity college connecticut", "the university of texas at austin", "university of florida", "sewanee the university of the south", "santa clara california university", "dickson college pennsylvania", "skidmore college ny", "georgia institute of technology main campus", "centre college kentucky", "boston university massachusetts", "connecticut college", "university maryland college park", "occ college california", "mount holyoke college massachusetts", "denison university ohio", "wofford college south carolina", "rhodes college tennessee", "university of richmond", "trinity university texas", "university of georgia", "university of california santa barbara", "brigham young university utah", "university of california davis", "saint johns university minnesota", "saint olaf college minnesota", "colorado school mines", "northeastern university massachusetts", "case western reserver university", "gettysburg college pennsylvania", "southern method university",
"university minnesota twin cities", "indiana university bloomington" };

	private static int rateCollege(String college)
	{
		for (int i = 0; i < top_colleges.length; i++)
		{
			// i under 25 : top 25 college best to worst rated
			if (top_colleges[i].toLowerCase().equals(college.toLowerCase())) {
				if(i < 25) {
					return 3;
				} else {
					return 2;
				}
			}
		}
		// return 1 if not in the top_colleges array
		return 1;
	}

	private String[][] scanTxts()
	{
		int len = all_txt_files.length;
		String[][] all_scanned = new String[len][500];

		for (int i = 0; i < len; i++)
		{
			FileScan fs = new FileScan("/home/heather/myGithub/HackISU_fall2017/linkedin-txts/" + all_txt_files[i]);
			all_scanned[i] = fs.getFSFile();
		}
		return all_scanned;

	}

	private List<String> getEducation(String[] resume){
		List<String> edu= new ArrayList<>();
		int startIndex = resume.length;
		int endIndex = resume.length;
		for (int i = 0; i<resume.length; i ++){
			//System.out.println(resume[i]);
			if (resume[i]!=null &&resume[i].contains("Education")){
				startIndex = i+1;
				for (int j = i; j < resume.length; j++){
					if (resume[j].equals("")){
						endIndex = j;
						break;
					}
				}
			}
		}
		int added = 0;
		for (int temp = startIndex; added<2 && temp<endIndex ; temp++){
			if (resume[temp].contains("University") || resume[temp].contains("College")){
				resume[temp]=resume[temp].replaceAll("\\W", " ");
				resume[temp]=resume[temp].replaceAll("  "," ");
				edu.add(resume[temp]);
				added ++;
			}
			if (resume[temp].toLowerCase().contains("master") || resume[temp].toLowerCase().contains("p.h.d")|| resume[temp].toLowerCase().contains("phd")|| resume[temp].toLowerCase().contains("undergrad")){
				resume[temp]=resume[temp].replaceAll("\\W", " ");
				resume[temp]=resume[temp].replaceAll("  "," ");
				edu.add(resume[temp]);
				added ++;
			}

		}
		while(edu.size() < 2){
			edu.add("0");
		}
		return edu;
	}

	private List<String> getExperience(String[] resume){
	  List<String> exp = new ArrayList<>();
	  int expStartIndex = 0;
	  int endIndex = resume.length;

		int eduStartIndex = resume.length;
		for (int i = 0; i<resume.length; i ++){
			if (resume[i]!=null &&resume[i].contains("Education")){
				eduStartIndex = i;
				break;
			}
		}

    for (int i = 0; i<resume.length; i ++){
      if (resume[i]!=null &&resume[i].contains("Experience")){
				expStartIndex = i + 1; // next line after exp
				break;
    	}
		}

		for (int j =expStartIndex; j <eduStartIndex && exp.size()<15; j ++){
			if(resume[j].contains("  -  ")){
				String time_range = resume[j];
				String position_company = "0";
				if(resume[j-1].equals("")){
					position_company = resume[j-2];
				}
				else{
					position_company = resume[j-1];
				}

				// now we get that #descrittion
				String pos = "0";
				String comp = "0";
				String exp_desc = "";
				for (int z = j + 2; resume[z]!=null && (!resume[z].equals("")); z++) {
					exp_desc += resume[z] + " ";
				}
				exp_desc = exp_desc.replaceAll("\\W", " ");
				exp_desc= exp_desc.replaceAll("  "," ");

				//System.out.println(position_company);
				//System.out.println(time_range);
				//System.out.println(exp_desc);
				int at_ind = position_company.indexOf("at");
				if (at_ind < 0){
					System.out.println(resume[0]);
					System.out.println("pos_comp:" + position_company + "after is " + resume[j]);
					pos = position_company;
				}
				else{
				 	pos = position_company.substring(0,at_ind-1);
				 	comp = position_company.substring((at_ind + 3), position_company.length());
					comp = comp.replaceAll(",", " ");
					System.out.println(pos);
					System.out.println(comp);
				}
				exp.add(comp);
				exp.add(pos);
				exp.add(exp_desc);
			}
		}

		while (exp.size()<15){
			exp.add("0");
		}
    return exp;
	 }


	public static void main(String[] args) throws IOException
	{
		Analysis a = new Analysis();
		String[][] t = a.scanTxts();
		int numResume = t.length;
		int succ_sets = 0;

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter("final.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			//Write a new student object list to the CSV file
			for (int i =0; t[i]!=null && i<t.length; i++) {
				succ_sets++;
				System.out.println(all_txt_files[i]);
				// add work experience
				List<String> experience = a.getExperience(t[i]);
				for (int n=0; n<15;n++) {
					fileWriter.append(experience.get(n));
					fileWriter.append(COMMA_DELIMITER);
				}

				List<String> education = a.getEducation(t[i]);
				fileWriter.append(education.get(0));  // school
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(education.get(1));  // degree
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(String.valueOf(rateCollege(education.get(0))));  //school score
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("CSV file was created successfully !!!");
			System.out.println(String.valueOf(succ_sets) + " out of " + String.valueOf(all_txt_files.length));

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
		}

	}

}
