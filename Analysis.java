
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

	

	public static void main(String[] args) 
	{
		Analysis a = new Analysis();
		String[][] t = a.scanTxts();
		System.out.println(t[0][0]);
		
	}

}
