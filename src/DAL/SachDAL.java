/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entities.Sach;
import Tools.FileToList;
import Tools.Ghi_List_Vao_File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SachDAL {
    public static ArrayList<Sach> show(){
        try{
            ArrayList<Sach> a = new ArrayList<Sach>();
            a = FileToList.Doc_Sach_Tu_File();
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    
    public static Sach GetSach(String tenSach){
        ArrayList<Sach> a = show();
        for(Sach item:a){
            if(item.getTenSach().equals(tenSach))
                return item;
        }
        return null;
    }
    
    public static boolean insert(ArrayList<Sach> list, Sach a) throws IOException{
        if(a.getMaSach().equals("")){
            JOptionPane.showMessageDialog(null,"Mã sách không được để trống");
            return false;
        }
        for(Sach item : list)
            if(a.getMaSach().equals(item.getMaSach())){
                JOptionPane.showMessageDialog(null,"Mã sách đã tồn tại");
                return false;
            }
        
        int index = list.size();
        for(int i=0;i<list.size();i++){
            if(a.getMaSach().compareTo(list.get(i).getMaSach())>0)
                index = i+1;
        }
        list.add(index,a);
        Ghi_List_Vao_File.ghi_Sach_Vao_File(list);
        return true;
    }
    
    public static boolean update(ArrayList<Sach> list, Sach a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaSach().equals(list.get(i).getMaSach())){
                index = i;
            }
        if(index != -1){
            list.set(index,a);
            Ghi_List_Vao_File.ghi_Sach_Vao_File(list);
            return true;
        }
        return false;
        
    }
    
    public static boolean delete(ArrayList<Sach> list, Sach a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaSach().equals(list.get(i).getMaSach())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            Ghi_List_Vao_File.ghi_Sach_Vao_File(list);
            return true;
        }
        else
        return false;
    }
}
