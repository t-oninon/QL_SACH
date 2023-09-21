/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entities.TacGia;
import Tools.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TacGiaDAL {
    public static ArrayList<TacGia> show(){
        try{
            ArrayList<TacGia> a = new ArrayList<TacGia>();
            a = FileToList.Doc_TacGia_Tu_File();
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    
    public static String GetTenTG(String maTG){
        ArrayList<TacGia> a = show();
        for(TacGia item:a){
            if(item.getMaTG().equals(maTG))
                return item.getTenTG();
        }
        return "";
    }
    
    public static boolean insert(ArrayList<TacGia> list, TacGia a) throws IOException{
        if(a.getMaTG().equals("")){
            JOptionPane.showMessageDialog(null,"Mã tác giả không được để trống");
            return false;
        }
        for(TacGia item : list)
            if(a.getMaTG().equals(item.getMaTG())){
                JOptionPane.showMessageDialog(null,"Mã tác giả đã tồn tại");
                return false;
            }
        int index = list.size();
        for(int i=0;i<list.size();i++){
            if(a.getMaTG().compareTo(list.get(i).getMaTG())>0)
                index = i+1;
        }
        list.add(index,a);
        Ghi_List_Vao_File.ghi_TacGia_Vao_File(list);
        return true;
    }
    
    public static boolean update(ArrayList<TacGia> list, TacGia a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaTG().equals(list.get(i).getMaTG())){
                index = i;
            }
        if(index != -1){
            list.set(index,a);
            Ghi_List_Vao_File.ghi_TacGia_Vao_File(list);
            return true;
        }
        return false;
        
    }
    
    public static boolean delete(ArrayList<TacGia> list, TacGia a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaTG().equals(list.get(i).getMaTG())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            Ghi_List_Vao_File.ghi_TacGia_Vao_File(list);
            return true;
        }
        else
        return false;
    }
}
