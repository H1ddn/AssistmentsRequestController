package Objects;

import java.time.LocalDate;
public class problem_request {
    private Long Uid;
    private Long problem_id;
    private Long teacher_id;
    private LocalDate date_created;

    public Long getUid() {
        return Uid;
    }

    public void setUid(final Long uid) {
        Uid = uid;
    }

    public Long getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(final Long problem_id) {
        this.problem_id = problem_id;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(final Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(final LocalDate date_created) {
        this.date_created = date_created;
    }
}
