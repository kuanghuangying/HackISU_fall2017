import java.util.List;
import java.util.ArrayList;

class Analysis {

	/* findSchoolScore()
	 * findGPA()
	 * findNumberWorkExperiences()
	 * findYearsOfExperience()
	 * findSkillSimilarity()
	 */
	String[] all_txt_files = {"Smit_Shah.txt", "Mavin_Martin.txt", "Sina_Ariyan.txt", "Chase_Ziwen_Cao.txt", "XiangbingJiProfile.txt", "Anurag_Bitton.txt", "p1.txt", "HaoGaiProfile.txt", "Zhou_Yu.txt", "Yufan_Lu.txt", "Zidong_Liu.txt", "Shiv_Patel.txt", "Aaron_Iglesias.txt", "Qing_Zhang.txt", "Jinal_Shah.txt", "Michael_Bediako.txt", "Tao_Ning.txt", "Alexey_Klishin.txt", "Lei_Wang.txt", "Alen_Kubati.txt", "Zach_Dischner.txt", "Xiwen_Zhang.txt", "Rohit_Sinha.txt", "Jerry_Luo.txt", "Swaroop_Manjunath.txt", "Bo_Yi.txt", "Dhrupad_Bhardwaj.txt", "Anshuman_Bansal.txt", "William_S._Fuller.txt", "Derrick_Chie.txt", "Mengfan_Chen.txt", "Zohaib_Iqbal.txt", "Alex_Vaky.txt", "Grace_Liu.txt", "Sharad_Banka.txt", "Aaron_Pankratz.txt", "Solaris_Nite.txt", "Feihong_Yang.txt", "Son_Pham.txt", "Sikai_Zhu.txt", "Shivani_Patil.txt", "Kevin_Nguyen.txt", "Tushar_Bhandari.txt", "Tyler_Bui-Palsulich.txt", "Mojtaba_Seyedhosseini.txt", "Shu_Wang.txt", "Michael_Taufen.txt", "Renchi_Yan.txt", "Akshay_Joshi.txt", "Raghav_Baldania.txt", "Michael_Bucher.txt", "Truman_Cranor.txt", "Luke_Lancaster.txt", "PJ_McNerney.txt", "Rundong_Lyu.txt", "Raisa_Cuevas.txt", "Ahmad_Zaraei.txt", "Shuguang_Han.txt", "Niharika_Ray.txt", "Animesh_Seth.txt", "Anuja_verma.txt", "Lingyun_Ruan.txt", "Hongyu_Song.txt", "Jialin_Yu.txt", "Ankit_Agarwal.txt", "Ribel_Fares.txt", "Morgan_Aw.txt", "Zhiwen_Fang.txt", "Hengchin_Yeh.txt", "Haitham_Gabr.txt", "Noah_Crocker.txt", "Anirudh_Subramanian.txt", "Liang_Tang.txt", "Harsha_Hassan_Somashekara.txt", "Li_Li.txt", "Ashish_Rathi.txt", "Ricardo_Alberto_Gaviria.txt", "Johann_Kerbrat.txt", "Cong_Qiao.txt", "Robert_Sperry.txt", "Madeleine_Esson.txt", "Vaishakh_Baragur_Narasimhareddy.txt", "Nathan_Stender.txt"};



	private String[][] scanTxts()
	{
		int len = all_txt_files.length;
		String[][] all_scanned = new String[len][500];

		for (int i = 0; i < len; i++)
		{
			FileScan fs = new FileScan("/home/mitchell/HackISU/Resume/HackISU_fall2017/linkedin-txts/" + all_txt_files[i]);
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
				edu.add(resume[temp]);
				edu.add(resume[temp+1].substring(0,resume[temp+1].indexOf(",")));
			}
		}
		return edu;
	}

	private List<String> getExperience(String[] resume){
                List<String> exp = new ArrayList<>();
                int startIndex = resume.length;
                int endIndex = resume.length;
		System.out.println(resume[0]);
                for (int i = 0; i<resume.length; i ++){
                        if (resume[i]!=null &&resume[i].contains("Experience")){
				int z = i + 1; // next line after exp
				String position_company = resume[z];
				String time_range = resume[z+1];

				// now we get that #descrittion
				String exp_desc = "";
				for (z = z + 3; resume[z]!=null && (resume[z].equals("") == false); z++) {
					exp_desc += resume[z] + " ";	
				}	
				System.out.println(position_company);
				System.out.println(time_range);
				System.out.println(exp_desc);
				int at_ind = position_company.indexOf("at");
				String pos = position_company.substring(0, at_ind-1);
				String comp = position_company.substring(at_ind + 3, position_company.length());
				System.out.println(pos);
				System.out.println(comp);


                        }
                } /*
                for (int temp = startIndex; temp<endIndex; temp++){
                        if (resume[temp].contains("University") || resume[temp].contains("College")){
                                edu.add(resume[temp]);
                                edu.add(resume[temp+1].substring(0,resume[temp+1].indexOf(",")));
                        }
                }*/
                return exp;
        }


	public static void main(String[] args)
	{
		Analysis a = new Analysis();
		String[][] t = a.scanTxts();
		List<String> education = a.getEducation(t[0]);
		
		List<String> experience = a.getExperience(t[0]);


	}

}
