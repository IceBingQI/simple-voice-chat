package de.maxhenkel.voicechat.config;

import de.maxhenkel.voicechat.voice.client.MicrophoneActivationType;

public class ClientConfig {

    public final ConfigBuilder.ConfigEntry<Double> voiceChatVolume;
    public final ConfigBuilder.ConfigEntry<Double> voiceActivationThreshold;
    public final ConfigBuilder.ConfigEntry<Double> microphoneAmplification;
    public final ConfigBuilder.ConfigEntry<MicrophoneActivationType> microphoneActivationType;
    public final ConfigBuilder.ConfigEntry<Integer> outputBufferSize;
    public final ConfigBuilder.ConfigEntry<String> microphone;
    public final ConfigBuilder.ConfigEntry<String> speaker;
    public final ConfigBuilder.ConfigEntry<Boolean> muted;
    public final ConfigBuilder.ConfigEntry<Boolean> disabled;

    public ClientConfig(ConfigBuilder builder) {
        voiceChatVolume = builder.doubleEntry("voice_chat_volume", 1D, 0D, 2D);
        voiceActivationThreshold = builder.doubleEntry("voice_activation_threshold", -50D, -127D, 0D);
        microphoneAmplification = builder.doubleEntry("microphone_amplification", 1D, 0D, 4D);
        microphoneActivationType = builder.enumEntry("microphone_activation_type", MicrophoneActivationType.PTT);
        outputBufferSize = builder.integerEntry("output_buffer_size", 6, 1, 16);
        microphone = builder.stringEntry("microphone", "");
        speaker = builder.stringEntry("speaker", "");
        muted = builder.booleanEntry("muted", false);
        disabled = builder.booleanEntry("disabled", false);
    }

}