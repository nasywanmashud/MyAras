package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

public class NotaReceive {

    String Status;
    private ArrayList<Nota> Nota = new ArrayList<Nota>();

    public ArrayList<com.intranet.app.ui.Model.Receive.Nota> getNota() {
        return Nota;
    }

    public void setNota(ArrayList<com.intranet.app.ui.Model.Receive.Nota> nota) {
        Nota = nota;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public NotaReceive(NotaReceive obj) {

        Status = obj.getStatus();
        Nota = obj.getNota();
    }
}

