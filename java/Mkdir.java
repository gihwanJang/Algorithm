import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Mkdir{

    public void makeDir(String path, String name){
        String newPath = path + "/" + name.substring(0, name.length()-4);
        File newFile = new File(newPath);
        if (!newFile.exists()) {	// 폴더가 존재하는지 체크, 없다면 생성
			if (newFile.mkdirs())
				System.out.println("폴더 생성 성공");
			else
				System.out.println("폴더 생성 실패");
		} else {	// 폴더가 존재한다면
            newFile.delete();
            newFile.mkdir();
			System.out.println("폴더가 이미 존재합니다.");
            System.out.println("삭제후 다시 생성합니다.");
        }

        try {
            Path filePath = Paths.get(path + "/" + name);
            Path filePathToMove = Paths.get(newPath + "/" + name);
            Files.move(filePath, filePathToMove);
        } catch (IOException e) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        Mkdir maker = new Mkdir();
        String path = "/Users/jang-gihwan/Desktop/Algorithm/cpp";
        File f = new File(path);
        FilenameFilter filter= new FilenameFilter() {
            public boolean accept(File f, String name) {
                return name.contains("cpp");
            }
          };

        if(f.exists()){
            System.out.println(path);

            String fileNames[] = f.list(filter);
            for(int i = 0; i < fileNames.length; ++i){
                maker.makeDir(path, fileNames[i]);
            }

            return;
        }
        System.out.println("path is not exists");
    }

}