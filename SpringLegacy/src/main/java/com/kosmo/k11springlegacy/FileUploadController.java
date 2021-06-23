package com.kosmo.k11springlegacy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	// 서버의 물리적 경로 알아보기
	@RequestMapping("/fileUpload/uploadPath.do")
	public void uploadPath(HttpServletRequest req, HttpServletResponse resp)throws IOException{
	
		// request객체를 통해 upload폴더의 물리적 경로 얻어옴
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		
		// response객체를 통해 MIME타입 설정
		resp.setContentType("text/html; charset=utf-8");
		
		// View를 호출 않고 컨트롤러에서 내용 즉시 출력
		PrintWriter pw = resp.getWriter();
		pw.print("/upload 디렉토리의 물리적경로: " + path);
	}
	// 파일 업로드 폼 매핑
	@RequestMapping("/fileUpload/uploadForm.do")
	public String uploadForm() {
		return "06FileUpload/uploadForm";
	}
	/*
	UUID(Universally Unique Identifier) :
	범용 고유 식별자
	randomUUID()를 통해 문자열을 생성하면
	하이픈이 4개 포함된 32자의 랜덤하고 유니크한 문자열 생성
	JDK에서 기본 클래스로 제공
	 */
	public static String getUuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println("생성된UUID-1: " + uuid);
		// 중간에 포함된 하이픈 제거
		uuid = uuid.replaceAll("-", "");
		System.out.println("생성된UUID-2: " + uuid);
		
		return uuid;
	}
	/*
	파일업로드 처리:
	파일업로드는 반드시 POST방식으로 전송해야 하므로
	컨트롤러 매핑 시 method, value 두 가지 속성 기술
	 */
	@RequestMapping(value="/fileUpload/uploadAction.do", method=RequestMethod.POST)
	public String uploadAction(Model model, MultipartHttpServletRequest req) {
		// 업로드 폴더의 물리적 경로 얻어오기
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		
		// 폼값과 파일명 저장 후 View로 전달하기 위한 맵 컬렉션
		Map returnObj = new HashMap();
		try {
			// 업로드 폼의 file속성의 필드 얻어옴(여기선 2개임)
			Iterator itr = req.getFileNames();
			
			// 업로드 처리 위한 각종 변수 생성
			MultipartFile mfile = null;
			String fileName = "";
			List resultList = new ArrayList();
			
			// 파일 외 폼값 전송
			String title = req.getParameter("title");
			System.out.println("title = " + title);
			
			/*
			물리적 경로를 기반으로 File객체를 생성 후
			지정된 디렉토리가 있는지 확인
			만약 없다면 디렉토리 생성
			 */
			File directory = new File(path);
			if(!directory.isDirectory()) {
				directory.mkdirs();
			}
			// 업로드 폼의 file필드 갯수 만큼 반복
			while(itr.hasNext()) {
				// 전송된 파일의 이름을 읽어옴
				fileName = (String)itr.next();
				mfile = req.getFile(fileName);
				System.out.println("mfile = " + mfile);
				//한글깨짐 방지 처리 후 전송된 파일명 가져옴
				String originalName = 
						new String(mfile.getOriginalFilename().getBytes(), "UTF-8");
				// 만약 서버로 전송된 파일이 없다면 while문의 처음으로 돌아감
				if("".equals(originalName)) {
					continue;
				}
				
				// 파일 확장자 얻어옴
				String ext = originalName.substring(originalName.lastIndexOf('.'));
				// UUID를 통해 얻어온 문자열에 확장자를 붙여줌
				String saveFileName = getUuid() + ext;
				// 물리적 경로에 새롭게 생성된 파일명으로 파일 저장
				File serverFullName = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFullName);
				
				Map file = new HashMap();
				file.put("originalName", originalName); // 원본 파일명
				file.put("saveFileName", saveFileName); // 저장된 파일명
				file.put("serverFullName", serverFullName); // 파일의 전체경로
				file.put("title", title); // 제목
				
				resultList.add(file);
			}
			returnObj.put("files", resultList);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("returnObj", returnObj);
		return "06FileUpload/uploadAction";
	}
	// 파일 목록 보기
	@RequestMapping("/fileUpload/uploadList.do")
	public String uploadList(HttpServletRequest req, Model model) {
		//서버의 물리적 경로 얻어오기
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		// 경로를 기반으로 파일객체 생성
		File file = new File(path);
		// 파일의 목록을 배열의 형태로 얻어옴
		File[] fileArray = file.listFiles();
		// 뷰로 전달할 파일목록을 저장하기 위해 MAP컬렉션 생성
		Map<String, Integer> fileMap = new HashMap<String, Integer>();
		for(File f : fileArray) {
			// Key값으로 파일명, Value값으로 파일의 용량을 저장
			fileMap.put(f.getName(), (int)Math.ceil(f.length()/1024.0));
		}
		model.addAttribute("fileMap", fileMap);
		return "06FileUpload/uploadList";
	}
	
}
