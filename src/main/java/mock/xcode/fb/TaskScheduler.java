package mock.xcode.fb;

/**
 * System Design: 默认使用多台机器
 * 这是一道经典的Resource Allocation题目: 开源框架有K8, YARN，Mesos
 * 要问面试官：
 * 1. 确认 scenario
 * 2. 谁用这个系统
 * 3. 能做什么操作？
 * 4. 设计数据库表
 * 5. delete finished tasks
 * 6. Resume task
 * 7. 一个Scheduler和多个Scheduler
 * priority, Master node, work node
 * filter conditions: 要能存很大的机器才可以跑
 * Job：job states
 * jenkins: liner workflow, job system
 Schedule task according to priority, ot time
 task_id, Created_time
 Status: completed, failed, waiting, being executed,pause,complete part of it
 */
public class TaskScheduler {
    public static void main(String[] args) {
        Mock81 mock81 = new Mock81();
        int[] input = {1, 3, 5, 2, 4, 5, 9, 6, 7};
        System.out.print(" " + mock81.longestK(input,3));
    }

}
