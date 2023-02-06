public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisor;

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
    public boolean equals(GraduateStudent graduateStudent){
        if(super.equals(graduateStudent)) {
            if(this.supervisor.equals(graduateStudent.supervisor) && (this.researchTopic.equals(graduateStudent.researchTopic))) {
                return true;
            }
        }
        return false;
    }

}
