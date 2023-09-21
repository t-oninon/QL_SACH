/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entities.TaiKhoan;
import Tools.*;
import java.io.IOException;
import java.util.ArrayList;


public class TaiKhoanDAL {
    public static ArrayList<TaiKhoan> show(){
        try{
            ArrayList<TaiKhoan> a = new ArrayList<TaiKhoan>();
            a = FileToList.Doc_TaiKhoan_Tu_File();
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    public static ArrayList<TaiKhoan> showAdmin(){
        try{
            ArrayList<TaiKhoan> a = new ArrayList<TaiKhoan>(),b;
            b = FileToList.Doc_TaiKhoan_Tu_File();
            for(TaiKhoan item:b){
                if(item.getVaiTro().equals("Admin"))
                    a.add(item);
            }
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    public static ArrayList<TaiKhoan> showUser(){
        try{
            ArrayList<TaiKhoan> a = new ArrayList<TaiKhoan>(),b;
            b = FileToList.Doc_TaiKhoan_Tu_File();
            for(TaiKhoan item:b){
                if(item.getVaiTro().equals("User"))
                    a.add(item);
            }
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    public static boolean insert(ArrayList<TaiKhoan> list, TaiKhoan a) throws IOException{
        for(TaiKhoan item : list)
            if(a.getMaTaiKhoan().equals(item.getMaTaiKhoan())){
                return false;
            }
        int index = list.size();
        for(int i=0;i<list.size();i++){
            if(a.getMaTaiKhoan().compareTo(list.get(i).getMaTaiKhoan())>0)
                index = i+1;
        }
        list.add(index,a);
        Ghi_List_Vao_File.ghi_TaiKhoan_Vao_File(list);
        return true;
    }
    
    public static boolean update(ArrayList<TaiKhoan> list, TaiKhoan a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaTaiKhoan().equals(list.get(i).getMaTaiKhoan())){
                index = i;
            }
        if(index != -1){
            list.set(index,a);
            Ghi_List_Vao_File.ghi_TaiKhoan_Vao_File(list);
            return true;
        }
        return false;
        
    }
    
    public static boolean delete(ArrayList<TaiKhoan> list, TaiKhoan a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaTaiKhoan().equals(list.get(i).getMaTaiKhoan())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            Ghi_List_Vao_File.ghi_TaiKhoan_Vao_File(list);
            return true;
        }
        else
        return false;
    }
}
