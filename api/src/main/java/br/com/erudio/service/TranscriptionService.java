package br.com.erudio.service;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class TranscriptionService {

    private final OpenAiAudioTranscriptionModel transcriptionModel;

    public TranscriptionService(@Value("${spring.ai.openai.api-key}") String apiKey) {
        OpenAiAudioApi openAiAudioApi = OpenAiAudioApi
                .builder()
                .apiKey(apiKey)
                .build();
        this.transcriptionModel = new OpenAiAudioTranscriptionModel(openAiAudioApi);
    }

    /**
     *
     * @param file: Arquivo mp3
     * @return Retorna a transcrição do áudio em uma String
     * @throws IOException
     */

    public String transcribeAudio(MultipartFile file) throws IOException {
        System.out.println("Iniciando a transcrição do áudio.");
        File tempFile = File.createTempFile("audio", ".mp3");
        file.transferTo(tempFile);

        OpenAiAudioTranscriptionOptions transcriptionOptions = OpenAiAudioTranscriptionOptions //Classe para configuração da transcrição
                .builder()
                .responseFormat(OpenAiAudioApi.TranscriptResponseFormat.TEXT) //Existem vários tipos, inclusive um tipo que é para legenda, ao que indica futuramente irá ser possível fazer transcrição para vídeo
                .language("pt") //Linguagem do retorno
                .temperature(0f)// Variador da sensatez na resposta
                .build();

        FileSystemResource audioFile = new FileSystemResource(tempFile);
        AudioTranscriptionPrompt transcriptionRequest = new AudioTranscriptionPrompt(audioFile, transcriptionOptions);

        AudioTranscriptionResponse response = transcriptionModel.call(transcriptionRequest); //Realização da requisição para a OpenAi realizar a transcrição do áudio

        tempFile.delete();// Apagando arquivo temporário para não comer memório

        return response.getResult().getOutput();
    }


}
