package tools;

import java.io.File;
import java.util.HashMap;

public class RepeatedFileFinder {
    private HashMap<String,String> hashMap=new HashMap<String,String>();
    private int contador=0;

    public RepeatedFileFinder(String directoryToSearch){
        File folder = new File(directoryToSearch);
        goOverFolder(folder);
    }
    private void goOverFolder(File folder){

        if(folder.isDirectory()){
            File[] files=folder.listFiles();
            if(files != null){
                for (File file:files) {
                    if(file.isDirectory()){
                        goOverFolder(file);
                    } else {
                        System.out.println("number of photo checked:"+contador++);
                        if(hashMap.containsKey(file.getName())){
                            System.out.println("******************************** Repeated image: "+hashMap.get(file.getName())+" with "+file.getAbsolutePath());
                        } else {
                            System.out.println("adding:"+file.getName());
                            hashMap.put(file.getName(),file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("This is not a folder");
        }

    }
}
