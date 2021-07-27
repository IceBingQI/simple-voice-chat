package de.maxhenkel.voicechat;

import de.maxhenkel.corelib.config.ConfigBase;
import de.maxhenkel.voicechat.voice.client.GroupPlayerIconOrientation;
import de.maxhenkel.voicechat.voice.client.HUDIconLocation;
import de.maxhenkel.voicechat.voice.client.MicrophoneActivationType;
import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig extends ConfigBase {

    public final ForgeConfigSpec.DoubleValue voiceChatVolume;
    public final ForgeConfigSpec.DoubleValue voiceActivationThreshold;
    public final ForgeConfigSpec.DoubleValue microphoneAmplification;
    public final ForgeConfigSpec.EnumValue<MicrophoneActivationType> microphoneActivationType;
    public final ForgeConfigSpec.IntValue outputBufferSize;
    public final ForgeConfigSpec.IntValue audioPacketThreshold;
    public final ForgeConfigSpec.BooleanValue clearFullAudioBuffer;
    public final ForgeConfigSpec.IntValue deactivationDelay;
    public final ForgeConfigSpec.ConfigValue<String> microphone;
    public final ForgeConfigSpec.ConfigValue<String> speaker;
    public final ForgeConfigSpec.BooleanValue muted;
    public final ForgeConfigSpec.BooleanValue disabled;
    public final ForgeConfigSpec.BooleanValue stereo;
    public final ForgeConfigSpec.BooleanValue hideIcons;
    public final ForgeConfigSpec.BooleanValue showGroupHUD;
    public final ForgeConfigSpec.BooleanValue showOwnGroupIcon;
    public final ForgeConfigSpec.DoubleValue groupHudIconScale;
    public final ForgeConfigSpec.EnumValue<HUDIconLocation> hudIconLocation;
    public final ForgeConfigSpec.EnumValue<GroupPlayerIconOrientation> groupPlayerIconOrientation;
    public final ForgeConfigSpec.ConfigValue<String> recordingDestination;

    public ClientConfig(ForgeConfigSpec.Builder builder) {
        super(builder);
        microphoneActivationType = builder
                .comment("Microphone activation type")
                .defineEnum("microphone_activation_type", MicrophoneActivationType.PTT);
        voiceActivationThreshold = builder
                .comment("The threshold for voice activation in dB")
                .defineInRange("voice_activation_threshold", -50D, -127D, 0D);
        voiceChatVolume = builder
                .comment("The voice chat volume")
                .defineInRange("voice_chat_volume", 1D, 0D, 2D);
        microphoneAmplification = builder
                .comment("The voice chat microphone amplification")
                .defineInRange("microphone_amplification", 1D, 0D, 4D);
        outputBufferSize = builder
                .comment(
                        "The size of the audio output buffer in packets",
                        "Higher values mean a higher latency, but less crackles",
                        "Increase this value if you have an unstable internet connection"
                )
                .defineInRange("output_buffer_size", 5, 1, 16);
        audioPacketThreshold = builder
                .comment(
                        "The maximum amount of audio packets that are held back, if a packet arrives out of order or gets dropped",
                        "This prevents discarding audio packets that are slightly out of order",
                        "Set this to 0 to disable"
                )
                .defineInRange("audio_packet_threshold", 3, 0, 16);
        clearFullAudioBuffer = builder
                .comment(
                        "If full audio buffers should get cleared",
                        "This potentially reduces audio latency on laggy servers",
                        "This does currently not work on Linux"
                )
                .define("clear_full_audio_buffer", false);
        deactivationDelay = builder
                .comment(
                        "The time it takes for the microphone to deactivate when using voice activation",
                        "A value of 1 means 20 milliseconds, 2=40 ms, 3=60 ms, ..."
                )
                .defineInRange("voice_deactivation_delay", 25, 0, 100);
        microphone = builder
                .comment("The microphone used by the voice chat", "Empty for default device")
                .define("microphone", "");
        speaker = builder
                .comment("The speaker used by the voice chat", "Empty for default device")
                .define("speaker", "");
        muted = builder
                .comment("If the microphone is muted (only when using voice activation)")
                .define("muted", false);
        disabled = builder
                .comment("If the voice chat is disabled (sound and microphone off)")
                .define("disabled", false);
        stereo = builder
                .comment("If the voice chat should use semi 3D stereo sound")
                .define("stereo", true);
        hideIcons = builder
                .comment("If the voice chat icons should be hidden")
                .define("hide_icons", false);
        showGroupHUD = builder
                .comment("If the group HUD should be visible")
                .define("show_group_hud", true);
        showOwnGroupIcon = builder
                .comment("If the own icon should be shown when in a group")
                .define("show_own_group_icon", true);
        groupHudIconScale = builder
                .comment("The scale of the group HUD")
                .defineInRange("group_hud_icon_scale", 2D, 0.01D, 10D);
        hudIconLocation = builder
                .comment("The location of the HUD icons")
                .defineEnum("hud_icon_location", HUDIconLocation.LEFT);
        groupPlayerIconOrientation = builder
                .comment("The orientation of the player icons in the group HUD")
                .defineEnum("group_player_icon_orientation", GroupPlayerIconOrientation.VERTICAL);
        recordingDestination = builder
                .comment("The location where recordings should be saved", "Leave empty for default location")
                .define("recording_destination", "");
    }

}