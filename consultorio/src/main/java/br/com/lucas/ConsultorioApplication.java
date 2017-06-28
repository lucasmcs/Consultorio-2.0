package br.com.lucas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ConsultorioApplication implements CommandLineRunner {   

//	@Autowired BancoRepository bancoRepository;
//	@Autowired PrioritarioRepository prioritarioRepository;
//	@Autowired ConvencionalRepository convencionalRepository;
//	@Autowired AtendenteRepository atendenteRepository;
//	@Autowired SenhaRepository senhaRepository;
//	
//	Banco caixa = new Banco();
//	Banco bb = new Banco();
//
//	Prioritario p1 = new Prioritario();
//	Prioritario p2 = new Prioritario();
//	Prioritario p3 = new Prioritario();
//
//	Convencional c1 = new Convencional();
//	Convencional c2 = new Convencional();
//	Convencional c3 = new Convencional();
//	Convencional c4 = new Convencional();
//
//	Atendente a1 = new Atendente();
//	Atendente a2 = new Atendente();
//	Atendente a3 = new Atendente();
//	Atendente a4 = new Atendente();
//	

	
	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}
	@Transactional
	public void run(String... args) throws Exception {
				
//		caixa.setEndereco("Rua do sol");
//		caixa.setNome("Caixa Economica Federal");
//		
//		bancoRepository.save(caixa);
//		
//		bb.setEndereco("Rua das arvores");
//		bb.setNome("Banco do Brasil");
//		
//		bancoRepository.save(bb);
//		
//		p1.setNome("Joao Gabriel");
//		p1.setTipoFila("p");
//
//		p2.setNome("Joao");
//		p2.setTipoFila("p");
//		
//		p3.setNome("Gabriel");
//		p3.setTipoFila("p");
//
//		c1.setNome("Maria Joaquina");
//		c1.setTipoFila("c");
//		c2.setNome("Gloria");
//		c2.setTipoFila("c");
//		c3.setNome("Joaquina");
//		c3.setTipoFila("c");
//		c4.setNome("Maria");
//		c4.setTipoFila("c");
//		
//		
//		a1.setMatricula("3445687");
//		a1.setNome("Juliana Albuquerque");
//		a1.setBanco(caixa);
//
//		a2.setMatricula("3447869");
//		a2.setNome("Marcos Andre");
//		a2.setBanco(bb);
//		
//		prioritarioRepository.save(p1);
//		prioritarioRepository.save(p2);
//		prioritarioRepository.save(p3);
//		convencionalRepository.save(c1);
//		convencionalRepository.save(c2);
//		convencionalRepository.save(c3);
//		convencionalRepository.save(c4);
//		atendenteRepository.save(a1);
//		atendenteRepository.save(a2);
//
//		// P1
//		Senha prioritario = new Senha(true);
//		prioritario.setHorarioChegada(new GregorianCalendar());
//		prioritario.setPessoa(p1);
//		
//		prioritario.setSenha(p1.getTipoFila()+prioritario.getContadorPrioritario());
//
//		senhaRepository.save(prioritario);
//		
//		// C1
//		Senha convencional = new Senha(false);
//		Thread.sleep(5000);
//		convencional.setHorarioChegada(new GregorianCalendar());
//		convencional.setPessoa(c1);
//		
//		convencional.setSenha(c1.getTipoFila()+convencional.getContadorConvencional());
//		
//		senhaRepository.save(convencional);
//		
//		// P2
//		Senha prioritario2 = new Senha(true);
//		Thread.sleep(5000);
//		prioritario2.setHorarioChegada(new GregorianCalendar());
//		prioritario2.setPessoa(p1);
//		
//		prioritario2.setSenha(p2.getTipoFila()+prioritario2.getContadorPrioritario());
//
//		senhaRepository.save(prioritario2);
//		
//		// P3
//		Senha prioritario3 = new Senha(true);
//		Thread.sleep(5000);
//		prioritario3.setHorarioChegada(new GregorianCalendar());
//		prioritario3.setPessoa(p3);
//		
//		prioritario3.setSenha(p3.getTipoFila()+prioritario3.getContadorPrioritario());
//
//		senhaRepository.save(prioritario3);
//		
//		// C2
//		Senha convencional2 = new Senha();
//		Thread.sleep(5000);
//		convencional2.setHorarioChegada(new GregorianCalendar());
//		convencional2.setPessoa(c2);
//		
//		convencional2.setSenha(c2.getTipoFila()+convencional2.getContadorConvencional());
//		
//		senhaRepository.save(convencional2);
//		
////		Senha convencional3 = new Senha(false);
////		Senha convencional4 = new Senha(false);
		
		
		
	
	}
}
