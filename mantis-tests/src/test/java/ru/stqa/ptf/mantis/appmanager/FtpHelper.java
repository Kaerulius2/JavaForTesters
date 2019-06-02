package ru.stqa.ptf.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper {
        private final ApplicationManager app;
        private final FTPClient ftp;

        public FtpHelper(ApplicationManager applicationManager) {
            this.app = applicationManager;
            ftp = new FTPClient();
        }

        // метод загружает новый файл, а старый переименовывает

        public void upload(File file, String target, String backup) throws IOException {
            //устанавливаем соединение с сервером
            ftp.connect(app.getProperty("ftp.host"));
            //логинимся
            ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
            //удаляем предыдущую резервную копию
            ftp.deleteFile(backup);
            //переименовываем удаленный файл (делаем резервную копию)
            ftp.rename(target, backup);
            //включаем пассивный режим передачи данных
            ftp.enterLocalPassiveMode();
            //из локального файла делаем InputStream(для чтения бинарных данных),
            // эти данные читаются из локального файла, передаются на удаленную машину,
            // где сохраняются в удаленном файле target
            ftp.storeFile(target, new FileInputStream(file));
            //разрываем соединение
            ftp.disconnect();

        }

        //метод восстанавливает исходный конфиг
        public void restore(String target, String backup) throws IOException {
            ftp.connect(app.getProperty("ftp.host"));

            ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
            ftp.deleteFile(target);
            ftp.rename(backup, target);
            ftp.disconnect();
        }

}
