package br.com.zup.edu.zupstore.aplicativo;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AplicativoController {
	
	public final AplicativoRepository repository;

	public AplicativoController(AplicativoRepository repository) {
		this.repository = repository;
	}
	
	
	@PatchMapping("/aplicativos/{id}/likes")
    @Transactional
    public ResponseEntity<?> incrementaLikes(@PathVariable Long id){
        Aplicativo aplicativo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aplicativo nao cadastrada no sistema."));

        aplicativo.aumentarLikes();

        repository.save(aplicativo);

        return ResponseEntity.noContent().build();
    }
	
	@PatchMapping("/aplicativos/{id}/download")
    @Transactional
    public ResponseEntity<?> incrementaDownloads(@PathVariable Long id){
        Aplicativo aplicativo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aplicativo nao cadastrada no sistema."));

        aplicativo.aumentarDownloads();

        repository.save(aplicativo);

//        return ResponseEntity.noContent().build();
        return ResponseEntity.ok(new AplicativoRespostaDTO(aplicativo));
    }
	
}
