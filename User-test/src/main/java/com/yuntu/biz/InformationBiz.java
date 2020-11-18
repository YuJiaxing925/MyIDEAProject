package com.yuntu.biz;

import com.yuntu.pojo.Information;

import java.util.List;

public interface InformationBiz {
    int sendMail(Information information);
    List<Information> getInformation(int i_receiveId);
    int isRead(int id);

    Information readInformation(int id );
}
