package com.smartfox.note.dto;

public class NoteDTO {
	private String name;
	private String label;

	public NoteDTO(String name, String label) {
		super();
		this.name = name;
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "NoteDTO [name=" + name + ", label=" + label + "]";
	}

}
