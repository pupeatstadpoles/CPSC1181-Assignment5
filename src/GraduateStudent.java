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

    public String getResearchTopic(){
        return this.researchTopic;
    }

    public String getSupervisor(){
        return this.supervisor;
    }

    @Override
    public boolean equals(Object graduateStudent){
        if(super.equals(graduateStudent)) {
            GraduateStudent grad = (GraduateStudent) graduateStudent;
            return ((this.supervisor.equals(grad.getSupervisor())) && (this.researchTopic.equals(grad.getResearchTopic())));
            }
        return false;
    }




    @Override
    public String toString(){
        return super.toString() + "[ Research Topic: " + researchTopic + ", Supervisor: " + supervisor + "]";
    }
}
