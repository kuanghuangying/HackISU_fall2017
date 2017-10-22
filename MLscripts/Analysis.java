import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;

class Analysis {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR= "\n";
	private static final String FILE_HEADER = "name,company0,job_title0,descrip0,company1,job_title1,descrip1,company2,job_title2,descrip2,company3,job_title3,descrip3,company4,job_title4,descrip4,school,degree,school_score,skill_score";


	/* findSchoolScore()
	 * findGPA()
	 * findNumberWorkExperiences()
	 * findYearsOfExperience()
	 * findSkillSimilarity()
	 */
	String[] all_txt_files = {"Smit_Shah.txt", "Mavin_Martin.txt", "Sina_Ariyan.txt", "Chase_Ziwen_Cao.txt", "XiangbingJiProfile.txt", "Anurag_Bitton.txt", "p1.txt", "HaoGaiProfile.txt", "Zhou_Yu.txt", "Yufan_Lu.txt", "Zidong_Liu.txt", "Shiv_Patel.txt", "Aaron_Iglesias.txt", "Qing_Zhang.txt", "Jinal_Shah.txt", "Michael_Bediako.txt", "Tao_Ning.txt", "Alexey_Klishin.txt", "Lei_Wang.txt", "Alen_Kubati.txt", "Zach_Dischner.txt", "Xiwen_Zhang.txt", "Rohit_Sinha.txt", "Jerry_Luo.txt", "Swaroop_Manjunath.txt", "Bo_Yi.txt", "Dhrupad_Bhardwaj.txt", "Anshuman_Bansal.txt", "William_S._Fuller.txt", "Derrick_Chie.txt", "Mengfan_Chen.txt", "Zohaib_Iqbal.txt", "Alex_Vaky.txt", "Grace_Liu.txt", "Sharad_Banka.txt", "Aaron_Pankratz.txt", "Solaris_Nite.txt", "Feihong_Yang.txt", "Son_Pham.txt", "Sikai_Zhu.txt", "Shivani_Patil.txt", "Kevin_Nguyen.txt", "Tushar_Bhandari.txt", "Tyler_Bui-Palsulich.txt", "Mojtaba_Seyedhosseini.txt", "Shu_Wang.txt", "Michael_Taufen.txt", "Renchi_Yan.txt", "Akshay_Joshi.txt", "Raghav_Baldania.txt", "Michael_Bucher.txt", "Truman_Cranor.txt", "Luke_Lancaster.txt", "PJ_McNerney.txt", "Rundong_Lyu.txt", "Raisa_Cuevas.txt", "Ahmad_Zaraei.txt", "Shuguang_Han.txt", "Niharika_Ray.txt", "Animesh_Seth.txt", "Anuja_verma.txt", "Lingyun_Ruan.txt", "Hongyu_Song.txt", "Jialin_Yu.txt", "Ankit_Agarwal.txt", "Ribel_Fares.txt", "Morgan_Aw.txt", "Zhiwen_Fang.txt", "Hengchin_Yeh.txt", "Haitham_Gabr.txt", "Noah_Crocker.txt", "Anirudh_Subramanian.txt", "Liang_Tang.txt", "Harsha_Hassan_Somashekara.txt", "Li_Li.txt", "Ashish_Rathi.txt", "Ricardo_Alberto_Gaviria.txt", "Johann_Kerbrat.txt", "Cong_Qiao.txt", "Robert_Sperry.txt", "Madeleine_Esson.txt", "Vaishakh_Baragur_Narasimhareddy.txt", "Nathan_Stender.txt"};

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
		for (int temp = startIndex; temp<endIndex; temp++){
			if (resume[temp].contains("University") || resume[temp].contains("College")){
				resume[temp]=resume[temp].replaceAll("\\W", " ");
				resume[temp]=resume[temp].replaceAll("  "," ");
				edu.add(resume[temp]);
				edu.add(resume[temp+1].substring(0,resume[temp+1].indexOf(",")));
				break;
			}
			else{
				edu.add("0");
				edu.add("0");
			}
		}
		return edu;
	}

	private List<String> getExperience(String[] resume){
	  List<String> exp = new ArrayList<>();
	  int expStartIndex = resume.length;
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

				System.out.println(position_company);
				System.out.println(time_range);
				System.out.println(exp_desc);
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


		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter("final.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			//Write a new student object list to the CSV file
			for (int i =0; i<t.length; i++) {
				fileWriter.append(t[i][0]);  //name
				fileWriter.append(COMMA_DELIMITER);

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
