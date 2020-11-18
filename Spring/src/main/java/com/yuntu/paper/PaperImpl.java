package com.yuntu.paper;

public class PaperImpl implements  Paper{
    //每行的字符数(通过Spring注入)
    private int charPerLine = 16;
    //每页的行数(通过Spring注入)
    private int linePerPage = 0;
    //纸张的内容
    private String content = "";
    //当前行的第几个字（0到charPerLine-1）
    private int posX = 0;
    //当前的行数
    private int posY = 0;
    //当前页数
    private int posP = 1;

    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }

    public void setLinePerPage(int linePerPage) {
        this.linePerPage = linePerPage;
    }

    /**
     * 把文字一个一个打印到纸张上
     * @param c
     */
    @Override
    public void putInChar(char c) {
        content+=c;
        posX++;
        //判断是否换行
        if (posX==charPerLine){
            content+= "\r\n";
            posX=0;
            posY++;
        }
        //判断是否换页
        if (posY==linePerPage){
            content+="\r\n";
            content+="这是第"+posP+"页\r\n";
            posY=0;
            posP++;
        }

    }

    /**
     * 获取内容
     * @return
     */
    @Override
    public String getContent() {
        if (posX==0&&posY==0){
            int count = linePerPage-posY;
            for (int i =0;i<count;i++){
                content+="\r\n";
            }
            content+="\r\n";
            content+="这是第"+posP+"页\r\n";
            content+="\r\n";
            content+="\r\n";
        }

        return content;
    }
}
