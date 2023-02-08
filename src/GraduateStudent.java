public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisor;

    /**
     * Public constructor
     * @param name
     * @param address
     * @param topic
     * @param supervisorName
     */
    public GraduateStudent(String name, String address, String topic, String supervisorName) {
        super(name, address);
        researchTopic = topic;
        supervisor = supervisorName;
    }


    /**
     * Getter method to retrieve research topic
     * @return research topic as String
     */
    public String getResearchTopic(){
        return this.researchTopic;
    }


    /**
     * Getter method to retrieve supervisor name
     * @return supervisor name as String
     */
    public String getSupervisor(){
        return this.supervisor;
    }


    /**
     * Checks if the Object passed in is the same GraduateStudent
     * @param graduateStudent Object being passed through, may not be a Student object
     * @return true if research topic and supervisor name match
     */
    @Override
    public boolean equals(Object graduateStudent){
        if(super.equals(graduateStudent)) { //name and address should match
            GraduateStudent grad = (GraduateStudent) graduateStudent;
            return ((this.supervisor.equals(grad.getSupervisor())) && (this.researchTopic.equals(grad.getResearchTopic())));
            }
        return false;
    }


    /**
     * toString override
     * @return String using Student.toString() and appends the reseaarch topic and supervisor at the end
     */
    @Override
    public String toString(){
        return super.toString() + "[ Research Topic: " + researchTopic + ", Supervisor: " + supervisor + "]";
    }
}
