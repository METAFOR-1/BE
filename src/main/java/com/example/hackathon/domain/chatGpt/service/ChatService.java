package com.example.hackathon.domain.chatGpt.service;

import com.example.hackathon.domain.chatGpt.dto.ChatGPTRequest;
import com.example.hackathon.domain.chatGpt.dto.ChatGPTResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final RestTemplate restTemplate;

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    public String getChatResponse(String prompt) {
        // GPT-3.5 또는 4 모델을 사용하여 질문을 전송
        ChatGPTRequest request = new ChatGPTRequest("gpt-4", prompt);
        ChatGPTResponse response = restTemplate.postForObject(OPENAI_API_URL, request, ChatGPTResponse.class);

        // GPT의 응답을 반환
        if (response != null && !response.getChoices().isEmpty()) {
            return response.getChoices().get(0).getMessage().getContent();
        }
        return "응답을 받을 수 없습니다.";
    }

    public String generateSummaryForKeyword(String keyword) {
        // 전달받은 키워드를 사용해 질문을 생성
        String question = String.format("%s 통증과 관련한 특징을 요약해줘. 환자 입장에서 이해가 되는 문장으로.", keyword);
        return getChatResponse(question);
    }

    public String generateDiagnosis(String ment) {
        // 전달받은 키워드를 사용해 질문을 생성
        String question = String.format("%s가 증상이야 해당 증상이 일어날 원인이 되는 근육을 다음 근육 중 하나를 선택해서 대답해줘. 내측익상근 ' '승모근' '경판상근' '두반극근 ' '악이복근' '경반극근 ' '다열근' '후두하근 ' '견갑거근 ' '사각근 '\n"
                + " '극상근' '극하근' '안윤근 ' '활배근' '대원근 ' '견갑하근 ' '삼각근' '외사복근' '복직근' '요추능형근' '장요근 '\n"
                + " '대둔근' '중둔근' '소둔근' '이상근 ' '봉장근' '치골근 ' '대퇴직근 ' '내측광근' '중간광근 ' '비복근' '가자미근'\n"
                + " '족저근 ' '장족지신근 ' '장모지신근 ' '모지외전근 ' '단족지굴근 ' '족저방형근 ' '모지내전근 ' '단모지굴근 '\n"
                + " '소원근 ' '흉쇄유돌근' '대흉근' '흉골근 ' '늑간근 ' '전거근 ' '상후거근 ' '교근' '흉장륵근' '요장륵근'\n"
                + " '흉최장근' '최소사각근 ' '제일배측골간근 ' '소지외전근 ' '제이배측골간근 ' '소흉근 ' '장족지굴근 ' '족골간근'\n"
                + " '삼두박근,장두' '장,단족지신근 ' '족소지외전근 ' '대관골근 ' '활경근 ' '협근 ' '후두근 ' '내폐쇄근 '\n"
                + " '대퇴근막장근 ' '척측수근신근 ' '단요측수근신근 ' '장요측수근신근 ' '완요골근 ' '수지신전근' '시지신전근 ' '회외근 '\n"
                + " '장장근 ' '요측수근굴근 ' '심, 천지굴근' '모지굴근 ' '원회내근 ' '모지대립근 ' '측두근' '외측광근' '내전근 '\n"
                + " '대내전근' '박근 ' '반건양근과 반막상근 ' '전경골근 ' '장,단비골근 ' '제삼비골근 ' '외측익상근 ' '하후거근 '\n"
                + " '추체근 ' '슬와근 ' '오훼완근 ' '이두박근 ' '상완근 ' '삼두박근,내측두' '삼두박근,외측두' '삼두박근,원위부'\n"
                + " '삼두박근,심내측두' '주근 ' '항문괄략근 ' '능형근 ' '장모지굴근 ' '대퇴이두근 ' '후경골근 ' '척측수근굴근 '\n"
                + " '족저근' '광배근' '슬와근' '늑간근' '이두박근' '상완근' '능형근' '내전근' '전경골근' 답변은 오로지 근육 이름 꼭 한 단어만 답변하도록 해. 꼭 한 단어야 한 단어를 넘기면 안돼", ment);
        return getChatResponse(question);
    }


}
