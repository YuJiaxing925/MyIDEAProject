package com.yuntu.dao;

import com.yuntu.pojo.Information;

import java.util.List;

public interface InformationMapper {
    int sendMail(Information information);
    List<Information> getInformation(int i_receiveId);
    int isRead(int id);
    Information readInformation(int id );
}
