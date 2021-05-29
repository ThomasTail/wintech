package com.mycompany.wintech;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/*
 * The MIT License
 *
 * Copyright 2021 Thomas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author Thomas
 */

public class GoalList {
  ArrayList<Goal> Goals;
  public GoalList(){
    Goals = new ArrayList<Goal>();
  }

  public void Save() throws Exception{
    FileOutputStream fos = new FileOutputStream("listData");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(Goals);
    oos.close();
    fos.close();
  }

  public void Load() throws Exception{
    try{
      FileInputStream fis = new FileInputStream("listData");
      ObjectInputStream ois = new ObjectInputStream(fis);
      Goals = (ArrayList) ois.readObject();
      ois.close();
      fis.close();
    }
    catch (IOException ioe)
      {
       ioe.printStackTrace();
       return null;
      }
    catch (ClassNotFoundException c)
      {
       System.out.println("Class not found");
       c.printStackTrace();
       return null;
      }
  }

  public void replace(ArrayList<Goal> a){
      Goals = a;
  }
  public  ArrayList<Goal> getList(String[] args){
    return Goals;
  }
}
