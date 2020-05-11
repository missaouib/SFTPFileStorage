package com.marin.sftpfilestorage.service;

import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class SftpService {

    private DefaultSftpSessionFactory getSessionFactory() {

        DefaultSftpSessionFactory sessionFactory = new DefaultSftpSessionFactory();
        sessionFactory.setHost("127.0.0.1");
        sessionFactory.setPort(22);
        sessionFactory.setAllowUnknownKeys(true);
        sessionFactory.setUser("marin");
        sessionFactory.setPassword("password123");

        return sessionFactory;
    }

    public void uploadFile(String fileName, InputStream inputStream) {

        SftpSession session = getSessionFactory().getSession();

        FileInputStream fileInputStream = null;
        try {
            session.write(inputStream, "upload/" + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        session.close();

    }

}
