/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.LeituraAgua.Main;

import br.com.LeituraAgua.controler.ConsumidorControler;
import br.com.LeituraAgua.controler.DistritoControler;
import br.com.LeituraAgua.controler.EnderecoControler;
import br.com.LeituraAgua.controler.HidrometroControler;
import br.com.LeituraAgua.controler.UsuarioControler;
import br.com.model.Consumidor;
import br.com.model.Distrito;
import br.com.model.Endereco;
import br.com.model.Hidrometro;
import br.com.model.Usuario;


public class AppLeituraAgua {
  
    public static void main(String[] args) {
//-----------seta e cadastra usuario comum e admin e executa logim -----------------------------------------
       
        UsuarioControler usuControl = new UsuarioControler();
        
        Usuario usuarioTeste = new Usuario();
        usuarioTeste.setLogin("admin2");
        usuarioTeste.setSenha(123456);
        usuarioTeste.setTipoUsuario("admin");
        
        usuControl.cadastrarNovo(usuarioTeste);
        System.out.println(usuarioTeste);
        
        Usuario usuarioTeste2 = new Usuario();
        usuarioTeste2.setLogin("usuario");
        usuarioTeste2.setSenha(102030);
        usuarioTeste2.setTipoUsuario("leiturista");
        
        usuControl.cadastrarNovo(usuarioTeste2);
        System.out.println(usuarioTeste2);

        UsuarioControler loginController = new UsuarioControler();
        loginController.logarUsuario("admin2", 123456);
        System.out.println(loginController.getMensagem());

        loginController.logarUsuario("usuario", 102030);
        System.out.println(loginController.getMensagem());
        
//************    seta e cadastra distrito  ********************************
        DistritoControler distcontrol = new DistritoControler();
        
        Distrito distrito = new Distrito();
        distrito.setCidade("Toledo");
        distrito.setNomeDistrito("Novo Sobradinho");
        
        distcontrol.cadastraNovo(distrito);
//************    seta e cadastra endereço 1 e 2 ********************************

        EnderecoControler endereControl = new EnderecoControler();
        
        Endereco endereco1 = new Endereco();
        endereco1.setRua("do cleumar");
        endereco1.setNumero(10);
        endereco1.setComplemento("casa");
        endereco1.setDistrito(distrito);
        
        endereControl.cadastraNovo(endereco1);
        
        Endereco endereco2 = new Endereco();
        endereco2.setRua("do cleumar");
        endereco2.setNumero(20);
        endereco2.setComplemento("casa");
        endereco2.setDistrito(distrito);
        
        endereControl.cadastraNovo(endereco2);

//************    seta e cadastra consumidor 1 e 2 ********************************
        
        ConsumidorControler consumidorControl = new ConsumidorControler();
        
        Consumidor consumidor1 = new Consumidor();
        consumidor1.setNome("morador 1");
        consumidor1.setContato("11-1111-1111");
        consumidor1.setCpf("111.111.111.11");
        consumidorControl.cadastraNovo(consumidor1);
        
        System.out.println(consumidor1);
        System.out.println(consumidorControl.getMensagem());
        
        Consumidor consumidor2 = new Consumidor();
        consumidor2.setNome("morador 2");
        consumidor2.setContato("22-2222-2222");
        consumidor2.setCpf("222.222.222.22");
        consumidorControl.cadastraNovo(consumidor2);
        
        System.out.println(consumidor2);
        System.out.println(consumidorControl.getMensagem());
        
//************    seta e cadastra hidrometro 1 e 2 ********************************

        HidrometroControler hidrometroControl = new HidrometroControler();
       
        Hidrometro hidrometro1 = new Hidrometro();
        hidrometro1.setConsumidor(consumidor1);
        hidrometro1.setLeituraInstalacao(100);
        hidrometro1.setEndereco(endereco1);
        hidrometro1.setSituacao(true);
        hidrometroControl.cadastraNovo(hidrometro1);
        
        Hidrometro hidrometro2 = new Hidrometro();
        hidrometro2.setConsumidor(consumidor2);
        hidrometro2.setLeituraInstalacao(100);
        hidrometro1.setEndereco(endereco2);
        hidrometro2.setSituacao(true);
        hidrometroControl.cadastraNovo(hidrometro2);
      /*  
      */             
    }
}