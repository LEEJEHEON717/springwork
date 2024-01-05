package com.khit.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class PageDTO {
	private int page;		//���� ������
	private int maxPage;	//�ִ�������(�Ѱ����� ���� ������)
	private int startPage;	//���� ������ ���� ���� ��������
	private int endPage;	//���� ������ ���� ������ ������ ��
}